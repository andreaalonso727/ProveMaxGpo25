
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
        //ps.setDate(2, Date.valueOf(com.getFecha());
        
       
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
    
}
