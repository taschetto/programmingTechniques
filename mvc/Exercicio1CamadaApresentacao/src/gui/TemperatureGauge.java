/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

/**
 *
 * @author Júlio
 */
public class TemperatureGauge {

    private int max, min, current;

    public TemperatureGauge(int min, int max) {
        this.min = min;
        this.max = max;
    }

    public void set(int level) {
        current = level;
    }

    public int get() {
        return current;
    }

    public int getMax() {
        return max;
    }

    public int getMin() {
        return min;
    }
}
