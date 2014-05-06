/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * DlgSeleciona.java
 *
 * Created on Apr 25, 2011, 8:44:18 PM
 */

package Interface;

import Negocio.Contribuinte;
import javax.swing.ListModel;

/**
 *
 * @author bcopstein
 */
public class DlgSeleciona extends javax.swing.JDialog {
    private ListModel contribuintes;
    private JanelaPrincipal jp;

    /** Creates new form DlgSeleciona */
    public DlgSeleciona(java.awt.Frame parent, boolean modal,ListModel contr) {
        super(parent, modal);
        jp = (JanelaPrincipal)parent;
        contribuintes = contr;
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        lstContribuintes = new javax.swing.JList();
        butOk = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lstContribuintes.setModel(contribuintes);
        lstContribuintes.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(lstContribuintes);

        butOk.setText("Ok");
        butOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butOkActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(butOk)
                        .addGap(170, 170, 170))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(butOk)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void butOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butOkActionPerformed
        Contribuinte c = (Contribuinte)(lstContribuintes.getSelectedValue());
        if (c!=null) jp.populaCampos(c);
        dispose();
    }//GEN-LAST:event_butOkActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton butOk;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList lstContribuintes;
    // End of variables declaration//GEN-END:variables

}