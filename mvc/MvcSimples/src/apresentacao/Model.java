/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package apresentacao;

/**
 *
 * @author Júlio
 */
public class Model {
    private int contador;
    
    public void setValor(int v){
        contador = v;
    }
    
    public int getValor() {
        return contador;
    }
    
    public void incrementaValor() {
        contador++;
    }
}
