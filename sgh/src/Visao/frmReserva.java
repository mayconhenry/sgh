/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visao;

import Logicas.fsuites;
import Dados.vsuites;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author MayconHenry
 */
public class frmReserva extends javax.swing.JInternalFrame {

    public frmReserva() {
        initComponents();
        this.setLocation(110,0);
        
        
       
    }
    
    void ocultar_columnas() {
        tbSuites.getColumnModel().getColumn(0).setMaxWidth(0);
        tbSuites.getColumnModel().getColumn(0).setMinWidth(0);
        tbSuites.getColumnModel().getColumn(0).setPreferredWidth(0);
    }
    
    void mostrar(String buscar) {
        try {
            DefaultTableModel modelo;
            fsuites func = new fsuites();
            modelo = func.mostrar(buscar);

            tbSuites.setModel(modelo);
            ocultar_columnas();
            
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(rootPane, e);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        entityManager = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("sgh?zeroDateTimeBehavior=convertToNullPU").createEntityManager();
        loginQuery = java.beans.Beans.isDesignTime() ? null : entityManager.createQuery("SELECT l FROM Login l");
        loginList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : loginQuery.getResultList();
        entityManager0 = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("sishotel?zeroDateTimeBehavior=convertToNullPU").createEntityManager();
        suiteQuery = java.beans.Beans.isDesignTime() ? null : entityManager0.createQuery("SELECT s FROM Suite s");
        suiteList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : suiteQuery.getResultList();
        suiteQuery1 = java.beans.Beans.isDesignTime() ? null : entityManager0.createQuery("SELECT s FROM Suite s");
        suiteList1 = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : suiteQuery1.getResultList();
        suiteQuery2 = java.beans.Beans.isDesignTime() ? null : entityManager0.createQuery("SELECT s FROM Suite s");
        suiteList2 = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : suiteQuery2.getResultList();
        suiteQuery3 = java.beans.Beans.isDesignTime() ? null : entityManager0.createQuery("SELECT s FROM Suite s");
        suiteList3 = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : suiteQuery3.getResultList();
        suiteQuery4 = java.beans.Beans.isDesignTime() ? null : entityManager0.createQuery("SELECT s FROM Suite s");
        suiteList4 = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : suiteQuery4.getResultList();
        sair = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Reserva de Quartos");

        sair.setText("Sair");
        sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sairActionPerformed(evt);
            }
        });

        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, suiteList4, jTable1);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${idsuites}"));
        columnBinding.setColumnName("Idsuites");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${tipoSuites}"));
        columnBinding.setColumnName("Tipo Suites");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${descricao}"));
        columnBinding.setColumnName("Descricao");
        columnBinding.setColumnClass(String.class);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();

        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setText("Selecione o Quarto");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 575, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(sair)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sair)
                .addContainerGap())
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sairActionPerformed
        this.dispose();
        
    }//GEN-LAST:event_sairActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        tela_suite_reserva form =new tela_suite_reserva();
        form.setVisible(true);
    }//GEN-LAST:event_jTable1MouseClicked

    
    private void txtNumeroActionPerformed(java.awt.event.ActionEvent evt) {                                          
        txtNumero.transferFocus();
    }                                         

        
    private javax.swing.JTable tbSuites;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtNumero;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmReserva.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        
    }
        //</editor-fold>
        /* Create and display the form */
        // Variables declaration - do not modify
        // End of variables declaration
        
        //</editor-fold>

        /* Create and display the form */
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.persistence.EntityManager entityManager;
    private javax.persistence.EntityManager entityManager0;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private java.util.List<Visao.Login> loginList;
    private javax.persistence.Query loginQuery;
    private javax.swing.JButton sair;
    private java.util.List<Visao.Suite> suiteList;
    private java.util.List<Visao.Suite> suiteList1;
    private java.util.List<Visao.Suite> suiteList2;
    private java.util.List<Visao.Suite> suiteList3;
    private java.util.List<Visao.Suite> suiteList4;
    private javax.persistence.Query suiteQuery;
    private javax.persistence.Query suiteQuery1;
    private javax.persistence.Query suiteQuery2;
    private javax.persistence.Query suiteQuery3;
    private javax.persistence.Query suiteQuery4;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
