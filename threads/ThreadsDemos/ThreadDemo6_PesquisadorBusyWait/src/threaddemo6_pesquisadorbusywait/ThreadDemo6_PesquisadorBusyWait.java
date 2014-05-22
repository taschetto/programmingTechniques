package threaddemo6_pesquisadorbusywait;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author bcopstein
 */
public class ThreadDemo6_PesquisadorBusyWait {
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
    e.execute(p1);
    e.execute(p2);
    
    int soma = 0;

    while(!p1.respOk() || !p2.respOk());
    
    //Thread.sleep(100);
    
    soma = p1.getResult()+p2.getResult();
    
    System.out.println("Maior da lista 1:"+p1.getResult());
    System.out.println("Maior da lista 2:"+p2.getResult());
    System.out.println("Soma: "+soma);
    e.shutdown();
  }
}
