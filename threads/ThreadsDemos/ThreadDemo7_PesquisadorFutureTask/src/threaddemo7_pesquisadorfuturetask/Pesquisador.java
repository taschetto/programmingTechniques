package threaddemo7_pesquisadorfuturetask;

import java.util.concurrent.*;
import java.util.*;

public class Pesquisador implements Callable<Integer>{
  private List<Integer> lista;
  
  public Pesquisador(List<Integer> umaLista){
      lista = umaLista;
  }
  
  public Integer call(){
      int maior = lista.get(0);
      for(Integer val:lista){
          if (maior < val) maior = val;
      }
      return(maior);
  } 
}