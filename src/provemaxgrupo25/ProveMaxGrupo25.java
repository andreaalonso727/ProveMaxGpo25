/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package provemaxgrupo25;
import java.time.LocalDate;
import provemaxgrupo25.Data.*;
import provemaxgrupo25.Entidades.*;

/**
 *
 * @author Sd
 */
public class ProveMaxGrupo25 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*-----------------------------------------------------------------------------------------------------*/
//        Producto producto = new Producto(5,"Microonda1", "Microonda Mas lindo de argentina", 60000, 15, false);
//      Producto producto1 = new Producto("Microonda2", "Microondas 21", 10000, 22, false);
//        
//        ProductoData produdata = new ProductoData();
//       
//           // Registrar productos
//        produdata.RegistrarProducto(producto);
//        produdata.RegistrarProducto(producto1);
//            
            //Modificar por el nombre cualquier producto
//          produdata.ModificarProducto(producto);
          
            //Eliminar producto por el id
//          produdata.EliminarProducto(producto);

            //Listar productos
//            for (Producto prod : produdata.ListarProducto()) {
//                System.out.println(prod);
//        }
         /*----------------------------------------------------------------------------------------------*/
//            
//            Proveedor proveedor = new Proveedor("Fravega", 21123456, "Bs As - Tulimanrea", "1102234566", true);
//            Proveedor proveedor1 = new Proveedor("Musimundo", 2034552345, "Tucuman - Nuñez Sagrado", "294532233", true);
//            
//            ProveedorData provedata = new ProveedorData();
//            
//            provedata.RegistrarProveedor(proveedor);
//            provedata.RegistrarProveedor(proveedor1);
         /*----------------------------------------------------------------------------------------------*/
         
//         LocalDate f1 = LocalDate.of(2023, 9, 15);
//        
//         LocalDate f2 = LocalDate.of(2023, 10, 5);
//         
//         for (Producto prod : produdata.ProdEntrefechas(f1, f2)) {
//             System.out.println(prod);
//        }
 /*---------------------------------------------------------------------------------------------------------*/
               // registrar compra
//            Proveedor proveedor = new Proveedor();
//            Proveedor proveedor1 = new Proveedor();
////            
//             proveedor.setIdProveedor(5);
//             proveedor1.setIdProveedor(6);
//              Compra compra= new Compra(proveedor, LocalDate.now());
//              Compra compra1= new Compra(proveedor1, LocalDate.now());          
//             CompraData comD= new CompraData();
//             
//             comD.guardarCompra(compra);
//             comD.guardarCompra(compra1);
/*---------------------------------------------------------------------------------------------------------*/
                //registrar detalle compra 
             Producto producto = new Producto();
             Producto producto1 = new Producto();
        
             producto.setIdProducto(3);
             producto1.setIdProducto(4);
             
              Compra compra= new Compra();
              Compra compra1= new Compra();
             compra.setIdCompra(6); 
             compra1.setIdCompra(7); 
             
              DetalleCompra detcom= new DetalleCompra(25, 23000, compra, producto);
              DetalleCompra detcom1= new DetalleCompra(12, 17000, compra1, producto1);
              DetalleCompraData detCompra = new DetalleCompraData();

               detCompra.guardarDetalleCompra(detcom);              
              
              detCompra.guardarDetalleCompra(detcom1);
    }
}