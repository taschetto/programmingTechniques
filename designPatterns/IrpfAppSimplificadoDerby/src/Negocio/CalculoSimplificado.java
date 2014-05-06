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
public class CalculoSimplificado implements CalculoIrpf {
    private static final double TAXA_DESCONTO_SIMPL = 0.5;

    public double impostoDevido(Contribuinte c) {
        double baseDeCalculo = c.getTotRend() - c.getContrPrev();
        double descPadrao = baseDeCalculo * TAXA_DESCONTO_SIMPL;
        baseDeCalculo = baseDeCalculo - descPadrao;
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
