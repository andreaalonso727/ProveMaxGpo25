
package provemaxgrupo25.Data;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import provemaxgrupo25.Entidades.Producto;


public class ProductoData {
    private Conexion con=null;
    
    public ProductoData(){
        
        con = Conexion.getConection();
    }
     
    public void RegistrarProducto(Producto producto){
    
        String sql= "INSERT INTO producto (nombreProducto,descripcion,precioActual,Stock) VALUES (?,?,?,?)";
        try{
            
            PreparedStatement ps = con.PrepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, producto.getNombreProd());
            ps.setString(2, producto.getDescripcion());
            ps.setInt(3, producto.getPrecioActual());
            ps.setInt(4, producto.getStock());
            ps.executeUpdate();
            
            Resultset rs=ps.getGeneratedKeys();
            if(rs.next()) {
                producto.setIdProducto(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Se Registro el producto con exito");
                
            }
            ps.close();
            
        } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Producto "+ex.getMessage());
    }catch(Exception e){
                System.out.println(e);
                {
                       
            }
         }
    }
}