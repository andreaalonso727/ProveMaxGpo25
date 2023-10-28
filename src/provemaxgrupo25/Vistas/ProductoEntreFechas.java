
package provemaxgrupo25.Vistas;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import provemaxgrupo25.Data.CompraData;
import provemaxgrupo25.Data.DetalleCompraData;
import provemaxgrupo25.Data.ProductoData;
import provemaxgrupo25.Entidades.DetalleCompra;
import provemaxgrupo25.Entidades.Producto;


public class ProductoEntreFechas extends javax.swing.JInternalFrame {

     private DefaultTableModel model;
     private ProductoData pd;
     private DetalleCompraData dcd;
     private List<DetalleCompra> listaDC;
     
    public ProductoEntreFechas() {
        initComponents();
        model= new DefaultTableModel();
        dcd=new DetalleCompraData();
        
        editartabla();
       
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
        jdchFecha1 = new com.toedter.calendar.JDateChooser();
        jdchFecha2 = new com.toedter.calendar.JDateChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtEntreFechas = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jbBuscar = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createTitledBorder("Productos entre Fechas"));
        setClosable(true);
        setIconifiable(true);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel1.setText("Seleccione Fechas:");

        jdchFecha1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jdchFecha1PropertyChange(evt);
            }
        });

        jdchFecha2.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jdchFecha2PropertyChange(evt);
            }
        });

        jtEntreFechas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jtEntreFechas);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel2.setText("y");

        jSeparator1.setBackground(new java.awt.Color(153, 153, 255));

        jbBuscar.setText("Buscar");
        jbBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 24, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jSeparator1)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jdchFecha1, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(42, 42, 42)
                        .addComponent(jdchFecha2, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(154, 154, 154)
                        .addComponent(jbBuscar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jdchFecha1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jdchFecha2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbBuscar)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jdchFecha1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jdchFecha1PropertyChange
//           
    }//GEN-LAST:event_jdchFecha1PropertyChange

    private void jdchFecha2PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jdchFecha2PropertyChange
         
    }//GEN-LAST:event_jdchFecha2PropertyChange

    private void jbBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscarActionPerformed
       try{
        
        // Obtener la fecha seleccionada del jdchFecha
        LocalDate fecha1= jdchFecha1.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate fecha2 = jdchFecha2.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        
        if (fecha1.isAfter(fecha2)){
         JOptionPane.showMessageDialog(this, "Fechas Incorrectas");
        } else {    
        cargarProducto(fecha1, fecha2);
        // Llamar al método para cargar productos por fecha
        }
       }catch(NullPointerException e){
           JOptionPane.showMessageDialog(this, "Debe completar los campos de Fecha");
           } 
    }//GEN-LAST:event_jbBuscarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton jbBuscar;
    private com.toedter.calendar.JDateChooser jdchFecha1;
    private com.toedter.calendar.JDateChooser jdchFecha2;
    private javax.swing.JTable jtEntreFechas;
    // End of variables declaration//GEN-END:variables

private void editartabla(){
    
    model.addColumn("IdDetalleCompra");
    model.addColumn("Nombre Producto");    
    model.addColumn("Fecha Compra1");
    
    jtEntreFechas.setModel(model); 
}


private void cargarProducto(LocalDate fecha1, LocalDate fecha2) {
    listaDC =dcd.ProdEntrefechas(fecha1, fecha2);
    model.setRowCount(0); // Limpia la tabla antes de cargar nuevos datos
    if (listaDC.isEmpty()){
    
    JOptionPane.showMessageDialog(this, "Lista Vacia" );
    }else {
        for (DetalleCompra item : listaDC) {
        model.addRow(new Object[]{
            item.getIdDetalle(),
            item.getProducto().getNombreProd(),
            item.getCompra().getFecha()
            
        });
    }
    }
}
}
