/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Negocio;

/**
 *
 * @author 12180247
 */
public class CalculoCompleto implements CalculoIrpf {
    public double impostoDevido(Contribuinte c) {
        double baseDeCalculo = c.getTotRend() - c.getContrPrev();
        double txDescDep = 0.0;
        if (c.getIdade() < 65) {
            if ((c.getNroDep() > 0) && (c.getNroDep() <= 2)) {
                txDescDep = 0.02;
            } else if ((c.getNroDep() > 2) && (c.getNroDep() <= 5)) {
                txDescDep = 0.035;
            } else if (c.getNroDep() > 5) {
                txDescDep = 0.05;
            }
        } else {
            if ((c.getNroDep() > 0) && (c.getNroDep() <= 2)) {
                txDescDep = 0.03;
            } else if ((c.getNroDep() > 2) && (c.getNroDep() <= 5)) {
                txDescDep = 0.045;
            } else if (c.getNroDep() > 5) {
                txDescDep = 0.06;
            }
        }
        double descDep = baseDeCalculo * txDescDep;
        baseDeCalculo = baseDeCalculo - descDep;
        double impPagar;
        if (baseDeCalculo <= 12000.0) {
            impPagar = 0;
        } else if ((baseDeCalculo >= 12000.0) && (baseDeCalculo < 24000.0)) {
            impPagar = (baseDeCalculo - 12000.0) * 0.15;
        } else {
            double p1 = (23999.0 - 12000.0) * 0.15;
            double p2 = (baseDeCalculo - 23999.0) * 0.275;
            impPagar = p1 + p2;
        }
        return (impPagar);
    }    
}
