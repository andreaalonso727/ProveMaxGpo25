/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package provemaxgrupo25.Data;

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
}
