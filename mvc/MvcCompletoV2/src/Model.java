/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Júlio
 */
public class Model{
    private int contador;
    private List<ModelListener> listeners;
    
    public Model(){
        listeners = new ArrayList<>();    
    }
    
    public void addModelListener(ModelListener l){
        listeners.add(l);
    }
    
    public void setValor(int v){
        contador = v;
        for(ModelListener l:listeners){
            l.valorAlterado(contador);
        }
    }
    
    public int getValor() {
        return contador;
    }
    
    public void incrementaValor() {
        contador++;
        for(ModelListener l:listeners){
            l.valorAlterado(contador);
        }
    }
}
