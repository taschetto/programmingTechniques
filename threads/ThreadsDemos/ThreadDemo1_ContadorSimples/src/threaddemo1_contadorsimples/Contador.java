package threaddemo1_contadorsimples;

public class Contador implements Runnable{
  private String nome;
  
  public Contador(String n){
    nome = n;
  }
  
  public void run(){
    System.out.println("Criando o contador: "+nome);
    for(int i=0; i<1000; i++){
      System.out.println(nome+": "+i);
    }
    System.out.println(nome+" encerrando.");
  }
}
