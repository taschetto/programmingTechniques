/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package apresentacao;

import java.util.Observable;
import java.util.Observer;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Júlio
 */
public class View implements Observer{
    private JTextField campoTexto;
    private JButton botao;
    private JFrame janela;
    
    public void inicializar() {
        janela = new JFrame("MVC Completo V3");
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
    
    public void associaController(Controller c){
        botao.addActionListener(c);
    }

    public void setCampoTexto(int v) {
        campoTexto.setText(""+v);
    }
    
    @Override
    public void update(Observable o, Object arg) {
        int v = ((Model)o).getValor();
        setCampoTexto(v);
    }
}
