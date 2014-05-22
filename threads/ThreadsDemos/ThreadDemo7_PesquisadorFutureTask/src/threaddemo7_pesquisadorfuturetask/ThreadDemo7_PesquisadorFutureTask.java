package threaddemo7_pesquisadorfuturetask;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 *
 * @author bcopstein
 */
public class ThreadDemo7_PesquisadorFutureTask {
  public static void main(String args[]){
    List<Integer> lista1 = new ArrayList<Integer>();
    List<Integer> lista2 = new ArrayList<Integer>();
    
    Random r = new Random();
    for(int i=0;i<20;i++){
        lista1.add(r.nextInt(100));
        lista2.add(r.nextInt(100));
    }
    
    Pesquisador p1 = new Pesquisador(lista1);
    Pesquisador p2 = new Pesquisador(lista2);
    
     ExecutorService e = Executors.newFixedThreadPool(2);
     Future<Integer> task1 = e.submit(p1);
     Future<Integer> task2 = e.submit(p2);
    
    int soma = 0;
    try{
      System.out.println("Maior da lista1: " + task1.get());
      System.out.println("Maior da lista2: " + task2.get());    	
      soma = task1.get()+task2.get();
    }catch(Exception ex){
        ex.printStackTrace();
        System.exit(0);
    }
    System.out.println("Soma: "+soma);
    e.shutdown();
  }
}