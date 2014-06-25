/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package apresentacao;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Júlio
 */
public class View {
    private JTextField campoTexto;
    private JButton botao;
    private JFrame janela;
    
    public void inicializar() {
        janela = new JFrame("MVC Simples");
        campoTexto = new JTextField(3);
        botao = new JButton("Incrementar");
        JPanel painel = new JPanel();
        painel.add(campoTexto);
        painel.add(botao);
        janela.getContentPane().add(painel);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.pack();
    }
    
    public void mostrar() {
        janela.setVisible(true);
    }
    
    public void setCampoTexto(int v) {
        campoTexto.setText(""+v);
    }
    
    public void associaController(Controller c){
        botao.addActionListener(c);
    }
}
