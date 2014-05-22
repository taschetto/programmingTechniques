package threaddemo5_pesquisadorsemsincronismo;

import java.util.*;

public class Pesquisador implements Runnable{
  private List<Integer> lista;
  private int resp;
  
  public Pesquisador(List<Integer> umaLista){
      lista = umaLista;
  }
  
  public int getResult(){
      return(resp);
  }
  
  public void run(){
    int maior = lista.get(0);
    for(Integer val:lista){
       if (val > maior) val = maior;
    }
    resp = maior;
  }
} 
