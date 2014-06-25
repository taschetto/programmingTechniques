/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package apresentacao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Júlio
 */
public class Controller implements ActionListener{
    private Model model;
    private View view;
    
    public void associaModel(Model m){
        model = m;
    }
    
    public void associaView(View v) {
        view = v;
        model.addObserver(view);
    }
    
    public void inicializaModel(int v) {
        model.setValor(v);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        model.incrementaValor();
    }
    
}
