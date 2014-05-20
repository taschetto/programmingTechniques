/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Negocio;

/*** EXERCÍCIO 3
 * 
 * Esta classe implementa um adapter da classe CalculoIrpfNaturalizado para a interface CalculoIrpf.
 * As alterações no projeto ocorrem nesta classe, no CalculoIrpfFactory e no enum TipoCalculo
 * (sem contar a interface gráfica).
 * 
 ***/
public class CalculoNaturalizado implements CalculoIrpf {
    public double impostoDevido(Contribuinte c) {
        CalculoIrpfNaturalizado ir = new CalculoIrpfNaturalizado(c);
        return ir.imposto_A_Pagar(ir.baseDeCalculo(), ir.fatorEspecifico());
    }
   
}
