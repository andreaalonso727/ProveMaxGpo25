
package provemaxgrupo25.Data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import provemaxgrupo25.Entidades.Proveedor;

public class ProveedorData {
    
    private Connection con=null;
    
    public ProveedorData(){
        
        con =  Conexion.getConection();
    }
     
    public void RegistrarProveedor(Proveedor proveedor){
    
        String sql= "INSERT INTO proveedor (razonSocial, domicilio, telefono, cuit, estado) VALUES (?,?,?,?,?)";
        try{   
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, proveedor.getRazonSocial());
            ps.setString(2, proveedor.getDomicilio());
            ps.setString(3, proveedor.getTelefono());
            ps.setString(4, proveedor.getCuit());
            ps.setBoolean(5, proveedor.isEstado());
            
            ps.executeUpdate();
            
            ResultSet rs=ps.getGeneratedKeys();
            if(rs.next()) {
                proveedor.setIdProveedor(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Se Registro el proveedor con exito");
                
            }
            ps.close();
            
        } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error al acceder a la tabla proveedor "+ex.getMessage());
    }catch(Exception e){
                System.out.println(e);             
            
         }
    }
      
    
     public void modificarProveedor (Proveedor proveedor){
       
        String sql= "UPDATE proveedor SET  cuit=?,domicilio=?, telefono=?,  estado=?  WHERE razonSocial=?";
        
        try {
            PreparedStatement ps= con.prepareStatement(sql);
           
            ps.setString(1, proveedor.getCuit());
            ps.setString(2, proveedor.getDomicilio());
            ps.setString(3,proveedor.getTelefono());
            ps.setBoolean(4, proveedor.isEstado());
            ps.setString(5,proveedor.getRazonSocial());
            
            int exito= ps.executeUpdate();
            if(exito==1){
                JOptionPane.showMessageDialog(null,"Proveedor modificado");
                
            }else{
                
                JOptionPane.showMessageDialog(null,"Proveedor no se puedo modificar");
            }
            
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null,"Error al modificar un proveedor");
            
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
             proveedor.setCuit(rs.getString("cuit"));
             proveedor.setDomicilio(rs.getString("domicilio"));
             proveedor.setTelefono(rs.getString("telefono"));
             proveedor.setEstado(rs.getBoolean("estado"));
                               
                       
            }else {
                JOptionPane.showMessageDialog(null, "No existe el proveedor");
            }
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al buscar los proveedores");
        }
            
        return proveedor;    
        }
    
    public List<Proveedor> ProveedBaja(){
        
        String sql="SELECT idProveedor,razonSocial,cuit,domicilio,telefono FROM proveedor WHERE estado=false";
            
            ArrayList<Proveedor> proveedores= new ArrayList<>();

        try {
            
            PreparedStatement ps=con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
                                    
            while(rs.next()){
                Proveedor proveedor=new Proveedor();
                proveedor.setIdProveedor(rs.getInt("idProveedor"));
                proveedor.setRazonSocial(rs.getString("razonSocial"));
                proveedor.setCuit(rs.getString("cuit"));
                proveedor.setDomicilio(rs.getString("domicilio"));
                proveedor.setTelefono(rs.getString("telefono"));
                proveedor.setEstado(false);
                proveedores.add(proveedor);
                
                }            
                    
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al buscar los proveedores baja");
            
        }
        return proveedores;
    }
public List<Proveedor> TodosProveed(){
        
        String sql="SELECT idProveedor,razonSocial,cuit,domicilio, telefono, estado FROM proveedor ";
            
            ArrayList<Proveedor> proveedores= new ArrayList<>();

        try {
            
            PreparedStatement ps=con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            
            while(rs.next()){
                Proveedor proveedor=new Proveedor();
                proveedor.setIdProveedor(rs.getInt("idProveedor"));
                proveedor.setRazonSocial(rs.getString("razonSocial"));
                proveedor.setCuit(rs.getString("cuit"));
                proveedor.setDomicilio(rs.getString("domicilio"));
                proveedor.setTelefono(rs.getString("telefono"));
                proveedor.setEstado(rs.getBoolean("estado"));
                proveedores.add(proveedor);
                }   
             
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al buscar todos los proveedores");
            
        }
        return proveedores;
    }
    
    public Proveedor buscarProveXNomb (String razonSocial){
            

        String sql="SELECT domicilio,telefono, cuit, estado FROM proveedor WHERE razonSocial =?";

        Proveedor proveedor=null;
        
        try {
            PreparedStatement ps= con.prepareStatement(sql);
            
            ps.setString(1,razonSocial);
            ResultSet rs= ps.executeQuery();
            if (rs.next()){
            
             proveedor=new Proveedor();
             proveedor.setRazonSocial(razonSocial);
             proveedor.setDomicilio(rs.getString("domicilio"));
             proveedor.setTelefono(rs.getString("telefono"));
             proveedor.setCuit(rs.getString("cuit"));
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
    
    public Proveedor buscarProveXCuit (String cuit){
            

        String sql="SELECT razonSocial,domicilio,telefono,estado FROM proveedor WHERE cuit =?";

        Proveedor proveedor=null;
        
        try {
            PreparedStatement ps= con.prepareStatement(sql);
            
            ps.setString(1,cuit);
            ResultSet rs= ps.executeQuery();
            if (rs.next()){
            
             proveedor=new Proveedor();
             proveedor.setCuit(cuit);
             proveedor.setRazonSocial(rs.getNString("razonSocial"));
             proveedor.setDomicilio(rs.getString("domicilio"));
             proveedor.setTelefono(rs.getString("telefono"));
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
            
        String sql="SELECT idProveedor, razonSocial, domicilio, telefono, cuit FROM proveedor WHERE estado=true";
       
        ArrayList<Proveedor> proveedores= new ArrayList<>();
        
        try {
            PreparedStatement ps= con.prepareStatement(sql);
            
            ResultSet rs= ps.executeQuery();
            while (rs.next()){
            
            Proveedor proveedor=new Proveedor();
            proveedor.setIdProveedor(rs.getInt("idProveedor"));
            proveedor.setRazonSocial(rs.getString("razonSocial"));
            proveedor.setDomicilio(rs.getString("domicilio"));
            proveedor.setCuit(rs.getString("cuit"));
            proveedor.setTelefono(rs.getString("telefono"));
            proveedor.setEstado(true);
            
            proveedores.add(proveedor);
            
            }
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al listar proveedores activos");
        }
            
        return proveedores;    
        }
    
    /*⮚	Mostrar qué proveedores, proveen el producto X. Ej. ¿Quienes me pueden proveer del producto Coca Cola?
proveedor*/
public List<Proveedor> obtenerProveedorPorProducto (String nombreprod){
 
     ArrayList<Proveedor> ProveedoresXProducto= new ArrayList<>();

     String sql= "SELECT p.idProveedor, p.razonSocial, p.cuit, p.domicilio, p.telefono, p.estado \n" + 
                  "FROM compra com \n" +
                  "JOIN proveedor p ON com.idProveedor = p.idProveedor \n" +
                  "JOIN detallecompra d ON d.idCompra = com.idCompra \n" +
                  "JOIN producto pro ON pro.idProducto = d.idProducto \n" +
                  "WHERE pro.nombreProducto =?"; 

       try {
           PreparedStatement ps = con.prepareStatement(sql);
           ps.setString(1, nombreprod);
           ResultSet rs = ps.executeQuery();
           while (rs.next()){
           
               Proveedor proveedor= new Proveedor();
               proveedor.setIdProveedor(rs.getInt("IdProveedor"));
               proveedor.setRazonSocial(rs.getNString("razonSocial"));
               proveedor.setCuit(rs.getString("cuit"));
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
  public void CambiarEstadoProveedor(int idProveedor) {
    String sql = "UPDATE proveedor SET estado = false WHERE idProveedor = ?";
    PreparedStatement ps;
    try {
        ps = con.prepareStatement(sql);
        ps.setInt(1, idProveedor); // Establecer el ID del producto que deseas cambiar

        int exito = ps.executeUpdate();
        if (exito == 1) {
            JOptionPane.showMessageDialog(null, "Estado del proveedor cambiado a 'false'");
        } else {
            JOptionPane.showMessageDialog(null, "No se pudo cambiar el estado del proveedor");
        }
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al cambiar el estado del proveedor");
    }
}
  public void CambiarEstadoProvT(int idProveedor) {
    String sql = "UPDATE proveedor SET estado = true WHERE idProveedor = ?";
    PreparedStatement ps;
    try {
        ps = con.prepareStatement(sql);
        ps.setInt(1, idProveedor); // Establecer el ID del producto que deseas cambiar

        int exito = ps.executeUpdate();
        if (exito == 1) {
            JOptionPane.showMessageDialog(null, "Estado del proveedor cambiado a 'true'");
        } else {
            JOptionPane.showMessageDialog(null, "No se pudo cambiar el estado del proveedor");
        }
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al cambiar el estado del proveedor");
    }
}  
}
