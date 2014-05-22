package threaddemo3_interrupcaodethreads;



public class Contador implements Runnable{
  private String nome;
  
  public Contador(String n){
    nome = n;
  }
  
  public void run(){
    System.out.println("Criando o contador: "+nome);
    int i;
    for(i=0; i<1000 && !Thread.interrupted(); i++){
      System.out.println(nome+": "+i);
    }
    System.out.println(nome+" encerrando. Contador="+i);
  }
}
