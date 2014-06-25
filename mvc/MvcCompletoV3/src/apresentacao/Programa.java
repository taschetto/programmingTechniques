/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package apresentacao;

import javax.swing.SwingUtilities;

/**
 *
 * @author Júlio
 */
public class Programa {
    private static void criarGui() {
        Model m = new Model();
        View v = new View();
        Controller c = new Controller();
        c.associaModel(m);
        c.associaView(v);
        v.inicializar();
        v.associaController(c);
        c.inicializaModel(0);
        v.mostrar();
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                 criarGui();
            }
        });
    }
}
