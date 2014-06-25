/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.Canvas;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;
import negocio.TemperatureModel;

/**
 *
 * @author Júlio
 */
public class GraphGUI extends JFrame {

    private Canvas gauges;
    private TemperatureGauge _farenheit;
    private TemperatureModel model;

    public GraphGUI() {
        initComponents();
    }

    private void initComponents() {
        this.setTitle("Temperature Gauge");
        _farenheit = new TemperatureGauge(-200, 300);
        JPanel Top = new JPanel();
        add("North", Top);
        gauges = new TemperatureCanvas(_farenheit);
        gauges.setSize(500, 280);
        add("Center", gauges);
        setSize(280, 320);
    }

    @Override
    public void paint(Graphics g) {
        int farenheit = (int) model.getF(); // Use the current data to paint
        _farenheit.set(farenheit);
        gauges.repaint();
        super.paint(g);
    }
    
    public void setModel(TemperatureModel m) {
        model = m;
    }
}
