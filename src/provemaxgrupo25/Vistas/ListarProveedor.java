/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package provemaxgrupo25.Vistas;

import java.util.List;
import javax.swing.table.DefaultTableModel;
import provemaxgrupo25.Data.ProveedorData;
import provemaxgrupo25.Entidades.Proveedor;

/**
 *
 * @author HP
 */
public class ListarProveedor extends javax.swing.JInternalFrame {

    private DefaultTableModel model;
    private ProveedorData provData;
    private List<Proveedor> listpactiv;
    private List<Proveedor> listpbaja;
    private List<Proveedor> listttodosp;
    
    /**
     * Creates new form listarProveedor
     */
    public ListarProveedor() {
        initComponents();
        
        provData = new ProveedorData();
        listpactiv = provData.listarProveedor();
        listpbaja = provData.ProveedBaja();
        listttodosp = provData.TodosProveed();
        model= new DefaultTableModel();
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTlistProv = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jRBActivo = new javax.swing.JRadioButton();
        jRBTodos = new javax.swing.JRadioButton();
        jRBbaja = new javax.swing.JRadioButton();
        jBAlta = new javax.swing.JButton();
        jBBaja = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);

        jTlistProv.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5"
            }
        ));
        jScrollPane1.setViewportView(jTlistProv);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Proveedores", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        jRBActivo.setText("Activo");
        jRBActivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRBActivoActionPerformed(evt);
            }
        });

        jRBTodos.setText("Todos");
        jRBTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRBTodosActionPerformed(evt);
            }
        });

        jRBbaja.setText("Baja");
        jRBbaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRBbajaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRBbaja)
                    .addComponent(jRBTodos)
                    .addComponent(jRBActivo))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jRBActivo)
                .addGap(18, 18, 18)
                .addComponent(jRBbaja)
                .addGap(18, 18, 18)
                .addComponent(jRBTodos)
                .addContainerGap(51, Short.MAX_VALUE))
        );

        jBAlta.setText("Alta Proveedor");

        jBBaja.setText("Baja Proveedor");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 356, Short.MAX_VALUE)
                .addGap(18, 18, 18))
            .addGroup(layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(jBAlta)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBBaja)
                .addGap(91, 91, 91))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBAlta)
                    .addComponent(jBBaja))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jRBActivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRBActivoActionPerformed
        try{
            
           
            jRBActivo.setSelected(true);
            jRBbaja.setSelected(false);
            jRBTodos.setSelected(false);
            
            ProvActivo();
            
            jBBaja.setEnabled(true);
            jBAlta.setEnabled(false);
            
        }catch(NullPointerException e){
            return;
        }
    }//GEN-LAST:event_jRBActivoActionPerformed

    private void jRBbajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRBbajaActionPerformed
        try{
           
            jRBbaja.setSelected(true);
            jRBActivo.setSelected(false);
            jRBTodos.setSelected(false);
            
            ProvBaja();
            
            jBAlta.setEnabled(true);
            jBBaja.setEnabled(false);
            
       }catch(NullPointerException e){
           return;
       }
    }//GEN-LAST:event_jRBbajaActionPerformed

    private void jRBTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRBTodosActionPerformed
        try{
           
            jRBTodos.setSelected(true);
            jRBActivo.setSelected(false);
            jRBbaja.setSelected(false);
            
            cargarProveedor();
            
            jBBaja.setEnabled(false);
            jBAlta.setEnabled(false);
            
       }catch(NullPointerException e){
           return;
       }
    }//GEN-LAST:event_jRBTodosActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBAlta;
    private javax.swing.JButton jBBaja;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRBActivo;
    private javax.swing.JRadioButton jRBTodos;
    private javax.swing.JRadioButton jRBbaja;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTlistProv;
    // End of variables declaration//GEN-END:variables


    private void editartabla(){
    
    model.addColumn("ID");
    model.addColumn("Razon Social");
    model.addColumn("Cuit");
    model.addColumn("Domicilio");
    model.addColumn("Telefono");
    model.addColumn("Estado");
    jTlistProv.setModel(model); 
    }

    private void borrarFilaTabla(){
        int indice= model.getRowCount() -1;
        for (int i= indice; i>=0; i--){
            model.removeRow(i);
        }
    }

    private void cargarProveedor() {
    listttodosp= provData.TodosProveed();
    DefaultTableModel model = (DefaultTableModel) jTlistProv.getModel();
    model.setRowCount(0); // Limpia la tabla antes de cargar nuevos datos

    for (Proveedor item : listttodosp) {
        model.addRow(new Object[]{
            item.getIdProveedor(),
            item.getRazonSocial(),
            item.getCuit(),
            item.getDomicilio(),
            item.getTelefono(),
           // item.isEstado()
        });
    }
}
    
    private void ProvActivo() {
    listpactiv = provData.listarProveedor(); // método devuelve una lista de proveedores con su estado

    DefaultTableModel model = (DefaultTableModel) jTlistProv.getModel(); 

    // Limpia la tabla antes de agregar nuevos datos
    model.setRowCount(0);

    for (Proveedor p : listpactiv) {
        if (p.isEstado()== true) { // Verifica el estado del proveedor activo
            model.addRow(new Object[] { p.getIdProveedor(), p.getRazonSocial(), p.getCuit(), p.getDomicilio(), p.getTelefono() });
        }
    }
    }
   private void ProvBaja() {
    listpbaja = provData.ProveedBaja(); // método que devuelve una lista de productos con estado inactivo (false)

    DefaultTableModel model = (DefaultTableModel) jTlistProv.getModel(); 

    // Limpia la tabla antes de agregar nuevos datos
    model.setRowCount(0);

    for (Proveedor p : listpbaja) {
        if (!p.isEstado()) { // Verifica si el estado del proveedor es inactivo (false)
            model.addRow(new Object[] { p.getIdProveedor(), p.getRazonSocial(), p.getCuit(), p.getDomicilio(), p.getTelefono() });
        }
    }
}
}
