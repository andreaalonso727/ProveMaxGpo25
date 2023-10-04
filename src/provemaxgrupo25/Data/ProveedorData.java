
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
            ps.setInt(4, proveedor.getCuit());
            ps.setBoolean(5, true);
            
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
       
        String sql= "UPDATE proveedor SET razonSocial=?, domicilio=?, telefono=?,  WHERE idProveedor=?";
        try {
            PreparedStatement ps= con.prepareStatement(sql);
            
            ps.setString(1, proveedor.getRazonSocial());
            ps.setString(2, proveedor.getDomicilio());
            ps.setString(3,proveedor.getTelefono());
            
            ps.setInt(4,proveedor.getIdProveedor());
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
        /*falta estado*/
        
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
            

        String sql="SELECT razonSocial,domicilio,telefomo FROM proveedor WHERE idProveedor =?";

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
                               
            /*falta estado*/
            
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
            
        String sql="SELECT idProveedor, razonSpcial, domicilio, telefono FROM proveedor WHERE estado=1";
        /*falta estado*/
        ArrayList<Proveedor> proveedores= new ArrayList<>();
        
        try {
            PreparedStatement ps= con.prepareStatement(sql);
            
            ResultSet rs= ps.executeQuery();
            while (rs.next()){
            
            Proveedor proveedor=new Proveedor();
            proveedor.setIdProveedor(rs.getInt("idProveedor"));
            proveedor.setRazonSocial(rs.getNString("domicilio"));
            proveedor.setTelefono(rs.getString("telefono"));
           
            //proveedor.setActivo(true);
            
            proveedores.add(proveedor);
            
            }
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al buscar un proveedor");
        }
            
        return proveedores;    
        }
    
}
