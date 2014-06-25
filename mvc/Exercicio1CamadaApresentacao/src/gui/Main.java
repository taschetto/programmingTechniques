/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import negocio.TemperatureModel;

/**
 *
 * @author Júlio
 */
public class Main {

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                TemperatureModel model = new TemperatureModel();
                GraphGUI gui = new GraphGUI();
                gui.setModel(model);
                gui.setVisible(true);
            }
        });
    }
}
