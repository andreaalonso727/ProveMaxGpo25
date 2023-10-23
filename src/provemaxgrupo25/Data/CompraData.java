
package provemaxgrupo25.Data;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import provemaxgrupo25.Entidades.Compra;
import provemaxgrupo25.Entidades.Proveedor;


public class CompraData {
    
     private Connection con=null;
     
     ProveedorData prove= new ProveedorData();
     
    
    public CompraData(){
        
        con =  Conexion.getConection();
    }
     
    public void guardarCompra ( Compra com ){
    
        String sql="INSERT INTO compra (idProveedor, fecha) VALUES (?, ?)";
    try {    
        PreparedStatement ps= con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ps.setInt(1, com.getProveedor().getIdProveedor());
        ps.setDate(2, Date.valueOf(com.getFecha()));
        
       
        ps.executeUpdate();
        ResultSet rs= ps.getGeneratedKeys();
        if(rs.next()){
        
            com.setIdCompra(rs.getInt(1));
            JOptionPane.showMessageDialog(null,"Compra guardada");
        }
        ps.close();              
                
    } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Compra ");
    }
    
    }
    
    
     public void modificarCompra (Compra com){
       
        String sql= "UPDATE compra SET idProveedor=?, fecha=?  WHERE idCompra=?";
        try {
            PreparedStatement ps= con.prepareStatement(sql);
            
            ps.setInt(1, com.getProveedor().getIdProveedor());
            ps.setDate(2, Date.valueOf(com.getFecha()));
            ps.setInt(3,com.getIdCompra());
            
            int exito= ps.executeUpdate();
            if(exito==1){
                JOptionPane.showMessageDialog(null,"Compra modificado");
                
            }else{
                
                JOptionPane.showMessageDialog(null,"Compra no se puedo modificar");
            }
            
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null,"Error al modificar una compra");
            
        }  
    
     }
    
    public Compra buscarCompra (Proveedor prove, LocalDate fecha){
            

        String sql="SELECT idCompra FROM compra WHERE idProveedor = ? AND fecha = ?";

        Compra compra=null;
        
        try {
            PreparedStatement ps= con.prepareStatement(sql);
            
            ps.setInt(1, prove.getIdProveedor());
            ps.setDate(2, Date.valueOf(fecha));
            
            ResultSet rs= ps.executeQuery();
            if (rs.next()){
            
             compra=new Compra();
             compra.setIdCompra(rs.getInt("idCompra"));
             compra.setProveedor( new Proveedor());
             compra.getProveedor().setIdProveedor(prove.getIdProveedor());
             compra.setFecha(fecha);
                                                                     
                       
            }else {
                JOptionPane.showMessageDialog(null, "No existe la compra");
            }
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al buscar la compra");
        }
            
        return compra;    
        }
    
    public List<Compra> listarCompra (){
            
        String sql="SELECT idCompra, idProveedor, fecha FROM compra ";
       
        ArrayList<Compra> compras= new ArrayList<>();
        
        try {
            PreparedStatement ps= con.prepareStatement(sql);
            
            ResultSet rs= ps.executeQuery();
            while (rs.next()){
            
            Compra compra=new Compra();
            compra.setIdCompra(rs.getInt("idCompra"));
            compra.setProveedor(new Proveedor());
            compra.getProveedor().setIdProveedor(rs.getInt("idProveedor"));
            compra.setFecha(rs.getDate("fecha").toLocalDate());
           
           
            
            compras.add(compra);
            
            }
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al buscar una compra");
        }
            
        return compras;    
        }
    
   public List<Compra> listarCompraPorProveedor (int idProveedor){
 
     ArrayList<Compra> compraXProveedores= new ArrayList<>();
     String sql= "SELECT p. razonSocial, cuit, domicilio, telefono, estado \n" +
                "FROM compra com JOIN proveedor p ON com.idProveedor = p.idProveedor \n" + "WHERE com.idProveedor=?";
     
       try {
           PreparedStatement ps = con.prepareStatement(sql);
           ps.setInt(1, idProveedor);
           ResultSet rs = ps.executeQuery();
           while (rs.next()){
           
               Compra compra = new Compra();
               compra.setProveedor (new Proveedor());
               compra.getProveedor().setRazonSocial(rs.getString("razonSocial"));
               compra.getProveedor().setCuit(rs.getInt("cuit"));
               compra.getProveedor().setDomicilio(rs.getString("domicilio"));
               compra.getProveedor().setTelefono(rs.getNString("telefono"));
               compra.getProveedor().setEstado(rs.getBoolean("estado"));
               compra.setFecha(rs.getDate("fecha").toLocalDate());
               compraXProveedores.add(compra);
               
                                        
           }
           
           ps.close();
            
       } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null,"Error al acceder a las tablas " + ex.getMessage());
       }
       return compraXProveedores;   
  
 }
    
   
    public Compra buscarCompraId (int id){
            

        String sql="SELECT idCompra, idProveedor, fecha FROM compra WHERE idCompra=?";

        Compra compra=null;
        
        try {
            PreparedStatement ps= con.prepareStatement(sql);
            
            ps.setInt(1, id);
            
            ResultSet rs= ps.executeQuery();
            if (rs.next()){
            
             compra=new Compra();
             compra.setIdCompra(rs.getInt("idCompra"));
             compra.setProveedor( new Proveedor());
             compra.getProveedor().setIdProveedor(rs.getInt("idProveedor"));
             compra.setFecha(rs.getDate("fecha").toLocalDate());
                                                                     
                       
            }else {
                JOptionPane.showMessageDialog(null, "No existe la compra");
            }
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al buscar la compra");
        }
            
        return compra;    
        }
    
       /* Todos los productos de una compra en particular. Ej. ¿Qué productos he adquirido en mi última compra?
       /* Aquellos productos que sean los más comprados entre fechas. Ej. ¿Qué productos he comprado más entre f1 y f2?*/

    
}
