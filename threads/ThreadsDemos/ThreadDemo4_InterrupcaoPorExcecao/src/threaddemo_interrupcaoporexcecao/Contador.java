package threaddemo_interrupcaoporexcecao;

import java.util.logging.Level;
import java.util.logging.Logger;



public class Contador implements Runnable{
  private String nome;
  
  public Contador(String n){
    nome = n;
  }
  
  public void run(){
    System.out.println("Criando o contador: "+nome);
    int i;
    for(i=0; i<100 && !Thread.interrupted(); i++){
      System.out.println(nome+": "+i);
            try {
                Thread.sleep(10);
            } catch (InterruptedException ex) {
                i+=5000; // Algum tratamento especial
                break;
            }
    }
    System.out.println(nome+" encerrando. Contador="+i);
  }
}
