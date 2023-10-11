
package provemaxgrupo25.Data;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
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
    
    String sql="INSERT INTO detalleCompra (cantidad, precioCosto,idCompra, idProducto) VALUES (?, ?, ?, ?)";
    try {    
        PreparedStatement ps= con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        
        ps.setInt(1, detcom.getCantidad());
        ps.setDouble(2, detcom.getPrecioCosto());
        ps.setInt(3, detcom.getCompra().getIdCompra());
        ps.setInt(4, detcom.getProducto().getIdProducto());
        
        
       
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
 }    
    
public DetalleCompra  buscarDetalle (int id){
            

        String sql="SELECT cantidad, PrecioCosto, idProducto, idCompra FROM DetalleCompra WHERE idDetalleCompra =?";

        DetalleCompra detcomp=null;
        
        try {
            PreparedStatement ps= con.prepareStatement(sql);
            
            ps.setInt(1,id);
            ResultSet rs= ps.executeQuery();
            if (rs.next()){
            
             detcomp= new DetalleCompra();
             detcomp.setIdDetalle(id);
             detcomp.setCantidad(rs.getInt("cantidad"));
             detcomp.setPrecioCosto(rs.getDouble("precioCosto"));
             ProductoData pd= new ProductoData();
             Producto producto= pd.BuscarProducto(rs.getInt("idProducto"));
             detcomp.setProducto(producto);
             CompraData cp= new CompraData();
             Compra compra=cp.buscarCompra(rs.getInt("idCompra"));
             detcomp.setCompra(compra);
                              
            
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
            
        String sql="SELECT idDetalleCompra, cantidad, precioCosto, idProducto, idCompra FROM DetalleCompra";
        
        ArrayList<DetalleCompra> listDetCompras= new ArrayList<>();
        
        try {
            PreparedStatement ps= con.prepareStatement(sql);
            
            ResultSet rs= ps.executeQuery();
            while (rs.next()){
            
            DetalleCompra detcomps=new DetalleCompra();
            detcomps.setIdDetalle(rs.getInt("idDetalle"));
            detcomps.setCantidad(rs.getInt("cantidad"));
            detcomps.setPrecioCosto(rs.getDouble("precioCosto"));
            ProductoData prodData= new ProductoData();
            Producto producto=prodData.BuscarProducto(rs.getInt("idProducto"));
            detcomps.setProducto(producto);
            CompraData comData= new CompraData();
            Compra compra= comData.buscarCompra(rs.getInt("idCompra"));
            detcomps.setCompra(compra);
            
            listDetCompras.add(detcomps);
            
            }
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al buscar un proveedor");
        }
            
        return listDetCompras;    
        }
    
    /*listar Todos los productos de una compra en una fecha específica. Ej. ¿Qué productos he comprado ayer a cualquier proveedor?
    
    */
    
    public List<DetalleCompra> listarProductoPorFecha (LocalDate fecha){
            
        String sql="SELECT dc.idDetalleCompra, dc.cantidad, dc.precioCosto, dc.idProducto, dc.idCompra, c.fecha AS fechaCompra  + "
                + "FROM DetalleCompra dc INNER JOIN Compra c ON dc.idCompra = c.idCompra WHERE c.fecha = ? ";
        
        ArrayList<DetalleCompra> listarProdXFchaCom= new ArrayList<>();
        
        try {
            PreparedStatement ps= con.prepareStatement(sql);
            ps.setDate(1, Date.valueOf(fecha));
            ResultSet rs= ps.executeQuery();
            while (rs.next()){
            
               DetalleCompra dc= new DetalleCompra();
               dc.setIdDetalle(rs.getInt("idDetalle"));
               dc.setCantidad(rs.getInt("cantidad"));
               dc.setPrecioCosto(rs.getDouble("precioCosto"));
               ProductoData produD= new ProductoData ();
               Producto producto = produD.BuscarProducto(rs.getInt("idProducto"));
               dc.setProducto(producto);
               CompraData comD= new CompraData();
               Compra compra= comD.buscarCompra(rs.getInt("idCompra"));
               dc.setCompra(compra);
               
                           
               listarProdXFchaCom.add(dc);
                          
            }
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al buscar al listarProdXFchaCom");
        }
            
        return listarProdXFchaCom;    
        }
    }
    

