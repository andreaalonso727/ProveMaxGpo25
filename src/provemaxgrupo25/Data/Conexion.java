/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package provemaxgrupo25.Data;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Sd
 */
public class Conexion {
    
    private static final String url="jdbc:mariadb://localhost/provemaxgrupo25";
    private static final String usuario="root";
    private static final String password="";
    
    private static Conexion connection=null;
    
    private Conexion(){
        //cargar driver
    
        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null,"Clase Connection: Error al cargar Driver"+ ex.getMessage());
        }
    
    }
    public static Conexion getConection(){
        
        //metodo statico para llavar x el main la connection de la bd
        Conexion con=null;
        if (connection == null){
                connection=new Conexion();
        }
        
        try {
            
            con = (Conexion) DriverManager.getConnection("jdbc:mariadb://localhost/provemaxgrupo25","root","");
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Error de conecxion" + ex.getMessage());
        
        }
    
        return con;
}
}
