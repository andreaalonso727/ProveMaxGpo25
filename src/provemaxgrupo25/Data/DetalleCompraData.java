
package provemaxgrupo25.Data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import provemaxgrupo25.Entidades.DetalleCompra;


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

 public void modificarDetalleCompra (DetalleCompra detcom){
       
        String sql= "UPDATE DetalleCompra SET cantidad=?, precioCosto=?, producto=?,compra=?  WHERE idDetalleCompra=?";
        try {
            PreparedStatement ps= con.prepareStatement(sql);
            
            ps.setInt(1, detcom.getCantidad());
            ps.setDouble(2, detcom.getPrecioCosto());
            ps.setInt(3, detcom.getProducto().getIdProducto());
            ps.setInt(4, detcom.getCompra().getIdCompra());
            int exito= ps.executeUpdate();
            if(exito==1){
                JOptionPane.showMessageDialog(null,"Detalle de Compra modificado");
                
            }else{
                
                JOptionPane.showMessageDialog(null,"El detalle de Compra no se puedo modificar");
            }
            
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null,"Error al modificar un Detalle de Compra");
            
        }  
    
public DetalleCompra buscar (int id){
            

        String sql="SELECT cantidad,PrecioCosto,producto, compra FROM DetalleCompra WHERE idDetalleCompra =?";

        DetalleCompra detcomp=null;
        
        try {
            PreparedStatement ps= con.prepareStatement(sql);
            
            ps.setInt(1,id);
            ResultSet rs= ps.executeQuery();
            if (rs.next()){
            
             detcomp=new DetalleCompra();
             detcomp.setIdDetalle(id);
             detcomp.setCantidad(rs.getInt("cantidad"));
             detcomp.setPrecioCosto(rs.getDouble("precioCosto"));
             Producto prod=prod.buscarProducto(rs.getInt("idProducto"));
             Compra comp=comp.buscarCompra(rs.getInt("idCompra"));
             detcomp.setProducto(prod);
             detcomp.setCompra(comp);
//             detcomp.setProducto(rs.getProducto().getIdProducto());
//             detcomp.setCompra(rs.getCompra().getIdCompra());                 
            
            }else {
                JOptionPane.showMessageDialog(null, "No existe ese detalle");
            }
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al buscar un Detalle de Compra");
        }
            
        return detcomp;    
        }
    
    public List<DetalleCompra> listarDetalleCompra (){
            
        String sql="SELECT idDetalleCompra, cantidad, precioCosto, producto, compra FROM DetalleCompra";
        
        ArrayList<DetalleCompra> listDetCompras= new ArrayList<>();
        
        try {
            PreparedStatement ps= con.prepareStatement(sql);
            
            ResultSet rs= ps.executeQuery();
            while (rs.next()){
            
            DetalleCompra detcomps=new DetalleCompra();
            detcomps.setIdDetalle(rs.getInt("idDetalle"));
            detcomps.setCantidad(rs.getInt("cantidad"));
            detcomps.setPrecioCosto(rs.getDouble("precioCosto"));
            Producto prod=prod.buscarProducto(rs.getInt("idProducto"));
            Compra comp=comp.buscarCompra(rs.getInt("idCompra"));
            detcomps.setProducto(prod);
            detcomps.setCompra(comp);
            
            listDetCompras.add(detcomps);
            
            }
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al buscar un proveedor");
        }
            
        return listDetCompras;    
        }
    }
    

