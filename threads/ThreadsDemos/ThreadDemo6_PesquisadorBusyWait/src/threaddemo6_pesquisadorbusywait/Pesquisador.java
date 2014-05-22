package threaddemo6_pesquisadorbusywait;

import java.util.*;

public class Pesquisador implements Runnable{
  private List<Integer> lista;
  private int resp;
  private boolean rOk;
  
  public Pesquisador(List<Integer> umaLista){
      lista = umaLista;
      rOk = false;
  }
  
  public int getResult(){
      return(resp);
  }
  
  public boolean respOk(){
      return(rOk);
  }
  
  public void run(){
    int maior = lista.get(0);
    for(Integer val:lista){
       if (val > maior) val = maior;
    }
    resp = maior;
    rOk = true;
  }
} 
