/*
 * JanelaPrincipal.java
 *
 * Created on Apr 19, 2011, 11:09:46 AM
 */
package Interface;

import Negocio.Contribuinte;
import Negocio.IrpfException;
import Negocio.TipoCalculo;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.ListModel;

/**
 *
 * @author bcopstein
 */
public class JanelaPrincipal extends javax.swing.JFrame {

    private CtrlGUI controlador;

    /**
     * Creates new form JanelaPrincipal
     */
    public JanelaPrincipal() {
        initComponents();
        try {
            controlador = new CtrlGUI();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Falha de inicialização. " + ex.getMessage());
        } catch (IrpfException ex) {
            JOptionPane.showMessageDialog(null, "Falha de inicialização. " + ex.getMessage());
        }
    }

    public void populaCampos(Contribuinte c) {
        tfNome.setText(c.getNome());
        tfCPF.setText(c.getCpf());
        tfIdade.setText(Integer.toString(c.getIdade()));
        tfDependentes.setText(Integer.toString(c.getNroDep()));
        tfContrPrev.setText(Double.toString(c.getContrPrev()));
        tfTotRend.setText(Double.toString(c.getTotRend()));
        controlador.setCorrente(c.getCpf());
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
        tfNome = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        tfCPF = new javax.swing.JTextField();
        tfIdade = new javax.swing.JTextField();
        tfDependentes = new javax.swing.JTextField();
        tfContrPrev = new javax.swing.JTextField();
        tfTotRend = new javax.swing.JTextField();
        btSalva = new javax.swing.JButton();
        btSel = new javax.swing.JButton();
        butCalcSimples = new javax.swing.JButton();
        butCalcCompleto = new javax.swing.JButton();
        butConsIdosos = new javax.swing.JButton();
        butCalcNaturalizado = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("IRPF");

        jLabel1.setText("Nome");

        jLabel2.setText("CPF");

        jLabel3.setText("Idade");

        jLabel4.setText("Dependentes");

        jLabel5.setText("Contribuicao previdenciaria");

        jLabel6.setText("Total de rendimentos");

        tfCPF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfCPFActionPerformed(evt);
            }
        });

        btSalva.setText("Salva");
        btSalva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalvaActionPerformed(evt);
            }
        });

        btSel.setText("Seleciona");
        btSel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSelActionPerformed(evt);
            }
        });

        butCalcSimples.setText("CalculaSimples");
        butCalcSimples.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butCalcSimplesActionPerformed(evt);
            }
        });

        butCalcCompleto.setText("CalculaCompleto");
        butCalcCompleto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butCalcCompletoActionPerformed(evt);
            }
        });

        butConsIdosos.setText("Consulta contr. idosos");
        butConsIdosos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butConsIdososActionPerformed(evt);
            }
        });

        butCalcNaturalizado.setText("CalculaNaturalizado");
        butCalcNaturalizado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butCalcNaturalizadoActionPerformed(evt);
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
                        .addComponent(btSalva)
                        .addGap(18, 18, 18)
                        .addComponent(btSel)
                        .addGap(18, 18, 18)
                        .addComponent(butCalcSimples)
                        .addGap(18, 18, 18)
                        .addComponent(butCalcCompleto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(butCalcNaturalizado))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(tfIdade, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(tfDependentes))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(tfContrPrev))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(tfTotRend))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfNome)
                            .addComponent(tfCPF))))
                .addGap(46, 46, 46))
            .addGroup(layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(butConsIdosos)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tfCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(tfIdade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfDependentes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(tfContrPrev, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(tfTotRend, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btSalva)
                    .addComponent(btSel)
                    .addComponent(butCalcSimples)
                    .addComponent(butCalcCompleto)
                    .addComponent(butCalcNaturalizado))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(butConsIdosos)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfCPFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfCPFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfCPFActionPerformed

    private void btSalvaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvaActionPerformed
        try {
            controlador.salva(tfNome.getText(), tfCPF.getText(), tfIdade.getText(), tfDependentes.getText(), tfContrPrev.getText(), tfTotRend.getText());
            controlador.setCorrente(tfCPF.getText());
            JOptionPane.showMessageDialog(this, "Contribuinte cadastrado com sucesso!!");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Formato de dados inválido. " + ex.getMessage());
        } catch (IrpfException ex) {
            JOptionPane.showMessageDialog(this, "Falha ao salvar. " + ex.getMessage());
        }
    }//GEN-LAST:event_btSalvaActionPerformed

    private void btSelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSelActionPerformed
        try {
            ListModel contribuintes = controlador.getContribuintes();
            DlgSeleciona dSel = new DlgSeleciona(this, true, contribuintes);
            dSel.setVisible(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Falha na busca. " + e.getMessage());
        }
    }//GEN-LAST:event_btSelActionPerformed

    private void butCalcSimplesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butCalcSimplesActionPerformed
        try {
            double calc = controlador.calcula(TipoCalculo.SIMPLIFICADO);
            String cpfContribuinte = controlador.getCorrente();
            DlgCalculo dCalc = new DlgCalculo(this, true, calc, cpfContribuinte);
            dCalc.setVisible(true);
        } catch (ContribuinteInexistenteException ex) {
            JOptionPane.showMessageDialog(this, "Contribuinte inexistente.");
        } catch (IrpfException ex) {
            JOptionPane.showMessageDialog(this, "Falha ao calcular imposto. " + ex.getMessage());
        }
    }//GEN-LAST:event_butCalcSimplesActionPerformed

    private void butCalcCompletoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butCalcCompletoActionPerformed
        try {
            double calc = controlador.calcula(TipoCalculo.COMPLETO);
            String cpfContribuinte = controlador.getCorrente();
            DlgCalculo dCalc = new DlgCalculo(this, true, calc, cpfContribuinte);
            dCalc.setVisible(true);
        } catch (ContribuinteInexistenteException ex) {
            JOptionPane.showMessageDialog(this, "Contribuinte inexistente.");
        } catch (IrpfException ex) {
            JOptionPane.showMessageDialog(this, "Falha ao calcular imposto. " + ex.getMessage());
        }
    }//GEN-LAST:event_butCalcCompletoActionPerformed

    private void butConsIdososActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butConsIdososActionPerformed
        try {
            ListModel contribuintes = controlador.getContribuintesIdosos();
            DlgConsIdosos dSel = new DlgConsIdosos(this, true, contribuintes);
            dSel.setVisible(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Falha na busca. " + e.getMessage());
        }
    }//GEN-LAST:event_butConsIdososActionPerformed

    /*** BEGIN EXERCÍCIO 3 ***/
    private void butCalcNaturalizadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butCalcNaturalizadoActionPerformed
        try {
            double calc = controlador.calcula(TipoCalculo.NATURALIZADO);
            String cpfContribuinte = controlador.getCorrente();
            DlgCalculo dCalc = new DlgCalculo(this, true, calc, cpfContribuinte);
            dCalc.setVisible(true);
        } catch (ContribuinteInexistenteException ex) {
            JOptionPane.showMessageDialog(this, "Contribuinte inexistente.");
        } catch (IrpfException ex) {
            JOptionPane.showMessageDialog(this, "Falha ao calcular imposto. " + ex.getMessage());
        }
    }//GEN-LAST:event_butCalcNaturalizadoActionPerformed
    /*** END EXERCÍCIO 3 ***/
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JanelaPrincipal().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btSalva;
    private javax.swing.JButton btSel;
    private javax.swing.JButton butCalcCompleto;
    private javax.swing.JButton butCalcNaturalizado;
    private javax.swing.JButton butCalcSimples;
    private javax.swing.JButton butConsIdosos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField tfCPF;
    private javax.swing.JTextField tfContrPrev;
    private javax.swing.JTextField tfDependentes;
    private javax.swing.JTextField tfIdade;
    private javax.swing.JTextField tfNome;
    private javax.swing.JTextField tfTotRend;
    // End of variables declaration//GEN-END:variables
}
