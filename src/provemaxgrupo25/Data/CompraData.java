
package provemaxgrupo25.Data;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
    
    public void eliminarProveedor(String razonSocial){
        
        int opcion = JOptionPane.showConfirmDialog(null, "Estas seguro que deseas eliminar este proveedor?");
               
        if(opcion == JOptionPane.YES_OPTION){
            
            String sql= "UPDATE proveedor SET estado=0 WHERE razonSocial=? AND estado = 1";

            try {
                PreparedStatement ps= con.prepareStatement(sql);

                ps.setString(1, razonSocial);
                int exito= ps.executeUpdate();

                if(exito==1){
                    JOptionPane.showMessageDialog(null,"Proveedor eliminado");
                }


            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null,"Error al eliminar un proveedor");
            }  
        }else{
            return;
        }
    
    }
    
    public Proveedor buscarProveedor (int id){
            

        String sql="SELECT razonSocial,domicilio,telefono, cuit, estado FROM proveedor WHERE idProveedor =?";

        Proveedor proveedor=null;
        
        try {
            PreparedStatement ps= con.prepareStatement(sql);
            
            ps.setInt(1,id);
            ResultSet rs= ps.executeQuery();
            if (rs.next()){
            
             proveedor=new Proveedor();
             proveedor.setIdProveedor(id);
             proveedor.setRazonSocial(rs.getNString("razonSocial"));
             proveedor.setDomicilio(rs.getString("domicilio"));
             proveedor.setTelefono(rs.getString("telefono"));
             proveedor.setCuit(rs.getInt("cuit"));
             proveedor.setEstado(rs.getBoolean("estado"));
                               
                       
            }else {
                JOptionPane.showMessageDialog(null, "No existe el proveedor");
            }
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al buscar un proveedor");
        }
            
        return proveedor;    
        }
    
    public List<Proveedor> listarProveedor (){
            
        String sql="SELECT idProveedor, razonSpcial, domicilio, telefono, cuit FROM proveedor WHERE estado=1";
       
        ArrayList<Proveedor> proveedores= new ArrayList<>();
        
        try {
            PreparedStatement ps= con.prepareStatement(sql);
            
            ResultSet rs= ps.executeQuery();
            while (rs.next()){
            
            Proveedor proveedor=new Proveedor();
            proveedor.setIdProveedor(rs.getInt("idProveedor"));
            proveedor.setRazonSocial(rs.getNString("domicilio"));
            proveedor.setTelefono(rs.getString("telefono"));
            proveedor.setEstado(true);
            
            proveedores.add(proveedor);
            
            }
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al buscar un proveedor");
        }
            
        return proveedores;    
        }
    
   public List<Proveedor> obtenerProveedorPorProducto (int idProducto){
 
     ArrayList<Proveedor> ProveedoresXProducto= new ArrayList<>();
     String sql= "SELECT p.idProveedor, razonSocial, cuit, domicilio, telefono, estado \n" +
                "FROM compra com JOIN proveedor p ON com.idProveedor = p.idProveedor \n" +
                "WHERE idProducto = ? AND p.estado = 1;";
     
       try {
           PreparedStatement ps = con.prepareStatement(sql);
           ps.setInt(1, idProducto);
           ResultSet rs = ps.executeQuery();
           while (rs.next()){
           
               Proveedor proveedor= new Proveedor();
               proveedor.setIdProveedor(rs.getInt("IdProveedor"));
               proveedor.setRazonSocial(rs.getNString("razonSocial"));
               proveedor.setCuit(rs.getInt("cuit"));
               proveedor.setDomicilio(rs.getString("domicilio"));
               proveedor.setTelefono(rs.getNString("telefono"));
               proveedor.setEstado(rs.getBoolean("estado"));
               ProveedoresXProducto.add(proveedor);
                                        
           }
           
           ps.close();
            
       } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null,"Error al acceder a las tablas " + ex.getMessage());
       }
       return ProveedoresXProducto;   
  
 }
    
    /*listar Todos los productos de una compra en una fecha específica. Ej. ¿Qué productos he comprado ayer a cualquier proveedor?
        Todas las compras a un Proveedor P. Ej. ¿Cuántas veces le he comprado al proveedor Bazar S.A.?
        Todos los productos de una compra en particular. Ej. ¿Qué productos he adquirido en mi última compra?
        Aquellos productos que sean los más comprados entre fechas. Ej. ¿Qué productos he comprado más entre f1 y f2?*/

    
}
