
package provemaxgrupo25.Data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import provemaxgrupo25.Entidades.*;


public class DetalleCompraData {
    
    
     private Connection con=null;
     
     CompraData comp= new CompraData();
     ProductoData produc= new ProductoData();
    
    public DetalleCompraData(){
        
        con =  Conexion.getConection();
    }
    
public void guardarDetalleCompra (DetalleCompra detcom ){
    
    String sql="INSERT INTO detalleCompra (cantidad, precioCosto,producto, compra) VALUES (?, ?, ?, ?)";
    try {    
        PreparedStatement ps= con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        
        ps.setInt(1, detcom.getCantidad());
        ps.setDouble(2, detcom.getPrecioCosto());
        ps.setInt(3, detcom.getProducto().getIdProducto());
        ps.setInt(4, detcom.getCompra().getIdCompra());
        
       
        ps.executeUpdate();
        ResultSet rs= ps.getGeneratedKeys();
        if(rs.next()){
        
            detcom.setIdDetalle(rs.getInt(1));
            JOptionPane.showMessageDialog(null,"Detalle de Compra guardada");
        }
        ps.close();              
                
    } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Detalle de Compra ");
    }
    
    } 
    
}
