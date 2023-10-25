
package provemaxgrupo25.Vistas;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.table.DefaultTableModel;
import provemaxgrupo25.Data.ProductoData;
import provemaxgrupo25.Entidades.Producto;


/**
 *
 * @author HP
 */
public class IngresarProducto extends javax.swing.JInternalFrame {


    private DefaultTableModel model;
    private List<Producto> listaP;
    private ProductoData pd;
        
        

    public IngresarProducto() {
        initComponents();
        pd = new ProductoData();
        limpiarCampos();


   
}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jtfNombre = new javax.swing.JTextField();
        jtfDescripcion = new javax.swing.JTextField();
        jtfCantidad = new javax.swing.JTextField();
        jtfPrecio = new javax.swing.JTextField();
        jrbEstado = new javax.swing.JRadioButton();
        jbBuscar = new javax.swing.JButton();
        jbIngresar = new javax.swing.JButton();
        jbModificar = new javax.swing.JButton();
        jbLimpiar = new javax.swing.JButton();
        jbSalir = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createTitledBorder("Ingresar Producto"));
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);

        jLabel1.setText("Nombre");

        jLabel2.setText("Descripcion");

        jLabel3.setText("Cantidad");

        jLabel4.setText("Precio");

        jLabel5.setText("Estado");

        jtfNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfNombreActionPerformed(evt);
            }
        });

        jrbEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbEstadoActionPerformed(evt);
            }
        });

        jbBuscar.setText("Buscar");
        jbBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBuscarActionPerformed(evt);
            }
        });

        jbIngresar.setText("Ingresar");
        jbIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbIngresarActionPerformed(evt);
            }
        });

        jbModificar.setText("Modificar");
        jbModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbModificarActionPerformed(evt);
            }
        });

        jbLimpiar.setText("limpiar");
        jbLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbLimpiarActionPerformed(evt);
            }
        });

        jbSalir.setText("Salir");
        jbSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(111, 111, 111)
                                .addComponent(jbModificar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jbLimpiar))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jtfNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(26, 26, 26)
                                        .addComponent(jbBuscar))
                                    .addComponent(jtfDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jtfPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jtfCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jrbEstado))))
                        .addGap(37, 37, 37))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jbIngresar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(157, 157, 157)
                .addComponent(jbSalir)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jtfNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbBuscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jtfDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jtfPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jtfCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jrbEstado, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbIngresar)
                    .addComponent(jbModificar)
                    .addComponent(jbLimpiar))
                .addGap(18, 18, 18)
                .addComponent(jbSalir)
                .addGap(5, 5, 5))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void jtfNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfNombreActionPerformed

    private void jbSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalirActionPerformed
        int opcion = JOptionPane.showConfirmDialog(this, "Quiere salir del formulario Producto?");
        
        if(opcion == JOptionPane.YES_OPTION){
            try {
                this.setClosed(true);
            } catch (PropertyVetoException ex) {
              
            }
        }
    }//GEN-LAST:event_jbSalirActionPerformed

    private void jbBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscarActionPerformed
        try{
            //Extraer los dato que se da en el view
            String nombre =jtfNombre.getText();
             
            Producto producto = pd.buscarProdNombre(nombre);          
             
             //if (producto != null) { 
             //jtfNombre.setText(producto.getNombreProd());
             jtfDescripcion.setText(producto.getDescripcion());
             jtfPrecio.setText(producto.getPrecioActual()+ "");
             jtfCantidad.setText(producto.getStock()+ "");
             jrbEstado.setSelected(producto.isEstado());
            
             //}else{ 
                 
                 //JOptionPane.showMessageDialog(null, "No existe ese producto");
             
             
        }catch(NullPointerException e){
           return;
        }
        //limpiarCampos();
    }//GEN-LAST:event_jbBuscarActionPerformed

    private void jbIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbIngresarActionPerformed
        try {
             // Extraer los datos que se ingresan en el view
            String nom = jtfNombre.getText();
            String descripcion = jtfDescripcion.getText();
            String precioText = jtfPrecio.getText();
            String cantidadText = jtfCantidad.getText();

        // Validar que los campos de cantidad y precio contengan solo números
        
        if (!precioText.matches("^\\d+(\\.\\d+)?$")) {
            JOptionPane.showMessageDialog(this, "El precio debe ser un número válido.");
            return;
        }
        if (!cantidadText.matches("\\d+")) {
            JOptionPane.showMessageDialog(this, "La cantidad debe ser un número entero.");
            return;
        }

        int cantidad = Integer.parseInt(cantidadText);
        double precio = Double.parseDouble(precioText);

        boolean estado = jrbEstado.isSelected();

        if (nom.isEmpty() || descripcion.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe completar todos los campos");
            return;
        } else {
            // Crear el objeto producto con las variables como parámetros
            Producto producto = new Producto(nom, descripcion, precio, cantidad, estado);

            // Pasamos el objeto producto al método que lo guarda en la base de datos
            pd.RegistrarProducto(producto);
        }

        limpiarCampos();

    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Error en el formato de los campos numéricos.");
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
    }

//          try{
//            Extraer los dato que se da en el view
//            String nom = jtfNombre.getText();
//            String descripcion = jtfDescripcion.getText();
//            int cantidad = Integer.parseInt(jtfCantidad.getText());
//            double precio = Double.parseDouble(jtfPrecio.getText());
//            
//            boolean estado = jrbEstado.isSelected();
//            
//            
//
//            if(nom.isEmpty() || descripcion.isEmpty()){
//                
//                JOptionPane.showMessageDialog(this, "Debe completar todos los campos");
//                return;
//                
//            }else{
//                
//                Crear el objeto alumno con las variables como parametros
//                Producto producto = new Producto(nom, descripcion, precio, cantidad, estado);
//
//                Pasamos es onjeto alumno al metodo que lo guarde en la db
//                pd.RegistrarProducto(producto);
//            }
//            
//            limpiarCampos();
//
//           
//        }catch(Exception e){
//            System.out.println(e);
//        }
    }//GEN-LAST:event_jbIngresarActionPerformed

    private void jbModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbModificarActionPerformed
        
        int opcion = JOptionPane.showConfirmDialog(this, "Quiere modificar este producto?");
              
        if(opcion == JOptionPane.YES_OPTION){
        
            try{
                     String nom = jtfNombre.getText();
                     String descripcion = jtfDescripcion.getText();
                     double precio = Double.parseDouble(jtfPrecio.getText());
                     int cantidad = Integer.parseInt(jtfCantidad.getText());
                     boolean estado = jrbEstado.isSelected();


                     if(nom.isEmpty() || descripcion.isEmpty()) {

                         JOptionPane.showMessageDialog(this, "Debe completar todos los campos");
                         return;

                     } else {
                         Producto producto= new Producto(nom, descripcion, precio, cantidad, estado);
                         pd.ModificarProducto(producto);
                        
                         limpiarCampos();
                                                                  
                     }
        }catch(NullPointerException e){
            return;
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(this, "Error en campos numericos");
        }catch(Exception e){
            System.out.println(e);
        }
        }
    }//GEN-LAST:event_jbModificarActionPerformed

    private void jrbEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbEstadoActionPerformed
        boolean estado = jrbEstado.isSelected();
        
        if (estado) {
         jrbEstado.setSelected(true);
} else {
        
        
        }        
        
               
    }//GEN-LAST:event_jrbEstadoActionPerformed

    private void jbLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbLimpiarActionPerformed
       limpiarCampos();
    }//GEN-LAST:event_jbLimpiarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JButton jbBuscar;
    private javax.swing.JButton jbIngresar;
    private javax.swing.JButton jbLimpiar;
    private javax.swing.JButton jbModificar;
    private javax.swing.JButton jbSalir;
    private javax.swing.JRadioButton jrbEstado;
    private javax.swing.JTextField jtfCantidad;
    private javax.swing.JTextField jtfDescripcion;
    private javax.swing.JTextField jtfNombre;
    private javax.swing.JTextField jtfPrecio;
    // End of variables declaration//GEN-END:variables





 private void limpiarCampos(){
        jtfNombre.setText("");
        jtfDescripcion.setText("");
        jtfPrecio.setText("");
        jtfCantidad.setText("");
        jrbEstado.setSelected(false);
 }

}
