    
package provemaxgrupo25.Data;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import provemaxgrupo25.Entidades.Producto;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import provemaxgrupo25.Entidades.Compra;



public class ProductoData {
    private Connection con=null;
    
    public ProductoData(){
        
        con =  Conexion.getConection();
    }
     
    public void RegistrarProducto(Producto producto){
    
        String sql= "INSERT INTO producto (nombreProducto,descripcion,precioActual,stock,estado) VALUES (?,?,?,?,?)";
        try{   
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, producto.getNombreProd());
            ps.setString(2, producto.getDescripcion());
            ps.setDouble(3, producto.getPrecioActual());
            ps.setInt(4, producto.getStock());
            ps.setBoolean(5, producto.isEstado());
            ps.executeUpdate();
            
            ResultSet rs=ps.getGeneratedKeys();
            if(rs.next()) {
                producto.setIdProducto(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Se Registro el producto con exito");
                
            }
            ps.close();
            
        } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Producto "+ex.getMessage());
    }catch(Exception e){
                System.out.println(e);
                
                       
            
         }
    }
    public void EliminarProducto(Producto producto) {
        
        String sql= "DELETE FROM producto WHERE producto.idProducto = ?";
        PreparedStatement ps;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, producto.getIdProducto());
            
            int exito=ps.executeUpdate();
            if (exito==1){
                JOptionPane.showMessageDialog(null, "Producto Eliminado");
                
            }else{
                JOptionPane.showMessageDialog(null, "No se elimino");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al eliminar un producto");
        }
    
 
    }
    
    public void ModificarProducto(Producto producto){
        
        try {
            String sql= "UPDATE producto SET descripcion=?,precioActual=?, stock=?, estado=?  WHERE nombreProducto=?";
            
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setString(1, producto.getDescripcion());
            ps.setDouble(2, producto.getPrecioActual());
            ps.setInt(3, producto.getStock());
            ps.setBoolean(4, producto.isEstado());
            ps.setString(5, producto.getNombreProd());
            
            
            int exito=ps.executeUpdate();
            if(exito==1){
                JOptionPane.showMessageDialog(null, "Producto modificado");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al modificar el producto");
        
            
        }
        
        
    }
    public Producto BuscarProducto(int id){
        
            String sql="SELECT nombreProducto,descripcion,precioActual,stock,estado FROM producto WHERE idProducto =?";
            
            Producto producto=null;
        try {
            
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                producto=new Producto();
                producto.setIdProducto(id);
                producto.setNombreProd(rs.getString("nombreProducto"));
                producto.setDescripcion(rs.getString("descripcion"));
                producto.setPrecioActual(rs.getDouble("precioActual"));
                producto.setStock(rs.getInt("stock"));
                producto.setEstado(rs.getBoolean("estado"));   
                
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al buscar un producto");
        }
        return producto;
            
        }
    public List<Producto> ListarProducto(){
        
        String sql="SELECT idProducto,nombreProducto,precioActual,stock FROM producto WHERE estado=true";
            
            ArrayList<Producto> productos= new ArrayList<>();

        try {
            
            PreparedStatement ps=con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
                                     
            while(rs.next()){
                Producto producto=new Producto();
                producto.setIdProducto(rs.getInt("idProducto"));
                producto.setNombreProd(rs.getString("nombreProducto"));
               
                producto.setPrecioActual(rs.getDouble("precioActual"));
                producto.setStock(rs.getInt("stock"));
                producto.setEstado(true);
                productos.add(producto);
                }             
                     
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al buscar un producto");
            
        }
        return productos;
    }

/*Aquellos productos que sean los más comprados entre fechas. Ej. ¿Qué productos he comprado más entre f1 y f2?*/

    public List<Producto> ProdEntrefechas(LocalDate f1, LocalDate f2){
        String sql= "SELECT p.nombreProducto, p.stock, p.estado \n" +
                    "FROM detallecompra dc \n" +
                    "JOIN producto p ON dc.idProducto = p.idProducto\n" +
                    "JOIN compra c ON dc.idCompra = c.idCompra\n" +
                    "WHERE c.fecha BETWEEN ? AND ? AND estado = 1;";
        
        ArrayList<Producto> productos= new ArrayList<>();
        

        try {
            
            PreparedStatement ps=con.prepareStatement(sql);
            
            ps.setDate(1, Date.valueOf(f1));
            ps.setDate(2, Date.valueOf(f2));
            
            ResultSet rs=ps.executeQuery();
            
            while(rs.next()){
                Producto producto=new Producto();
                
                producto.setNombreProd(rs.getString("nombreProducto"));
                producto.setEstado(rs.getBoolean("estado"));
                producto.setStock(rs.getInt("stock"));
                
                productos.add(producto);
                
                
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al buscar un producto");
            
        }
        return productos;
    }
public Producto buscarProdNombre (String nombre){
    
    Producto producto = null;
    
    String sql= "SELECT descripcion,precioActual,stock,estado FROM producto WHERE nombreProducto=?";
    
    
     
    try {
        PreparedStatement ps= con.prepareStatement(sql);
        
            ps.setString(1,nombre);
            ResultSet rs= ps.executeQuery();
            
            if (rs.next()){
            
            producto=new Producto();
            //producto.setIdProducto(rs.getInt("idProducto"));
            producto.setDescripcion(rs.getNString("descripcion"));
            producto.setPrecioActual(rs.getDouble("precioActual"));
            producto.setStock(rs.getInt("stock"));                                           
            producto.setEstado(rs.getBoolean("estado"));
                                               
            
            }else {
                JOptionPane.showMessageDialog(null, "No existe el producto");
            }
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla producto");
            
        }
         return producto;
               
    }
public List<Producto> ObtenerProdBaja(){
        
        String sql="SELECT idProducto,nombreProducto,precioActual,stock FROM producto WHERE estado=false";
            
            ArrayList<Producto> productos= new ArrayList<>();

        try {
            
            PreparedStatement ps=con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
                                    
            while(rs.next()){
                Producto producto=new Producto();
                producto.setIdProducto(rs.getInt("idProducto"));
                producto.setNombreProd(rs.getString("nombreProducto"));
                
                producto.setPrecioActual(rs.getDouble("precioActual"));
                producto.setStock(rs.getInt("stock"));
                
                productos.add(producto);
                
                }            
                    
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al buscar un producto");
            
        }
        return productos;
    }
public List<Producto> ObtenerTodosProd(){
        
        String sql="SELECT idProducto,nombreProducto,precioActual,stock, estado FROM producto ";
            
            ArrayList<Producto> productos= new ArrayList<>();

        try {
            
            PreparedStatement ps=con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            
            int stockMinimo= 10;
            while(rs.next()){
                Producto producto=new Producto();
                producto.setIdProducto(rs.getInt("idProducto"));
                producto.setNombreProd(rs.getString("nombreProducto"));
                producto.setPrecioActual(rs.getDouble("precioActual"));
                producto.setStock(rs.getInt("stock"));
                producto.setEstado(rs.getBoolean("estado"));
                productos.add(producto);
                if (producto.getStock()< stockMinimo){
                
                 JOptionPane.showMessageDialog(null, "Producto por debajo del Stock minimo  " + producto.getNombreProd());
                }
                }   
             
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al buscar un producto");
            
        }
        return productos;
    }
 public void EliminarProd(int id) {
        
        String sql= "DELETE FROM producto WHERE idProducto = ?";
        PreparedStatement ps;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            
            int exito=ps.executeUpdate();
            if (exito==1){
                JOptionPane.showMessageDialog(null, "Producto Eliminado");
                
            }else{
                JOptionPane.showMessageDialog(null, "No se elimino");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al eliminar un producto");
        }
    
 
    }
  public void CambiarEstadoProducto(int idProducto) {
    String sql = "UPDATE producto SET estado = false WHERE idProducto = ?";
    PreparedStatement ps;
    try {
        ps = con.prepareStatement(sql);
        ps.setInt(1, idProducto); // Establecer el ID del producto que deseas cambiar

        int exito = ps.executeUpdate();
        if (exito == 1) {
            JOptionPane.showMessageDialog(null, "Estado del producto cambiado a 'false'");
        } else {
            JOptionPane.showMessageDialog(null, "No se pudo cambiar el estado del producto");
        }
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al cambiar el estado del producto");
    }
}
  public void CambiarEstadoProdT(int idProducto) {
    String sql = "UPDATE producto SET estado = true WHERE idProducto = ?";
    PreparedStatement ps;
    try {
        ps = con.prepareStatement(sql);
        ps.setInt(1, idProducto); // Establecer el ID del producto que deseas cambiar

        int exito = ps.executeUpdate();
        if (exito == 1) {
            JOptionPane.showMessageDialog(null, "Estado del producto cambiado a 'true'");
        } else {
            JOptionPane.showMessageDialog(null, "No se pudo cambiar el estado del producto");
        }
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al cambiar el estado del producto");
    }
}
    }
       
       
    
    
