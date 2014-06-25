/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package apresentacao;

import java.util.Observable;

/**
 *
 * @author Júlio
 */
public class Model extends Observable{
    private int contador;
    
    public Model(){
        contador = 0;
    }
    
    public void setValor(int v){
        contador = v;
        setChanged();
        notifyObservers();
    }
    
    public int getValor() {
        return contador;
    }
    
    public void incrementaValor() {
        contador++;
        setChanged();
        notifyObservers();
    }
}
