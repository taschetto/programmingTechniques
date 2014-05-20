/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Negocio;

/**
 *
 * @author guilherme
 */
public class CalculoIrpfFactory {
    public static CalculoIrpf createInstance(TipoCalculo t)
    {
        switch(t)
        {
            case COMPLETO:
                return new CalculoCompleto();
            case SIMPLIFICADO:
                return new CalculoSimplificado();
                
            /*** BEGIN EXERCÍCIO 3 ***/
            case NATURALIZADO:
                return new CalculoNaturalizado();
            /*** END EXERCÍCIO 3 ***/
                
                
            default:
                return null;
        }
    }
}
