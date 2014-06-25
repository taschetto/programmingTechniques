/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

/**
 *
 * @author Júlio
 */
public class TemperatureModel {

    private double temperatureF = 32.0;

    public double getF() {
        return temperatureF;
    }

    public double getC() {
        return (temperatureF - 32.0) * 5.0 / 9.0;
    }

    public void setF(double tempF) {
        temperatureF = tempF;
    }

    public void setC(double tempC) {
        temperatureF = tempC * 9.0 / 5.0 + 32.0;
    }
}
