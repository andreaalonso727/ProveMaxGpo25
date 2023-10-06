
package provemaxgrupo25.Data;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import provemaxgrupo25.Entidades.Producto;
import java.sql.ResultSet;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;



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
            ps.setBoolean(5, true);
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
            }else{
                JOptionPane.showMessageDialog(null, "No se pudo modificar este producto");
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
                
                
            }else{
                JOptionPane.showMessageDialog(null, "No existe ese producto");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al buscar un producto");
        }
        return producto;
            
        }
    public List<Producto> ListarProducto(){
        
        String sql="SELECT idProducto,nombreProducto,descripcion,precioActual,stock FROM producto WHERE estado=1";
            
            ArrayList<Producto> productos= new ArrayList<>();

        try {
            
            PreparedStatement ps=con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                Producto producto=new Producto();
                producto.setIdProducto(rs.getInt("idProducto"));
                producto.setNombreProd(rs.getString("nombreProducto"));
                producto.setDescripcion(rs.getString("descripcion"));
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




}
       
       
    
    
