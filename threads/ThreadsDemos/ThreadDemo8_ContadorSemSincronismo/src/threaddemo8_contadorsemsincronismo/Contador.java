package threaddemo8_contadorsemsincronismo;

public class Contador
{
    private int valor; 

    public Contador()
    {
        valor = 0;
    }
    
    public void incrContador()
    {
        System.out.print(" Incrementando contador ");
        int novoValor = valor + 1;
        System.out.println(" , novo valor e: " + novoValor);
        valor = novoValor;
    } 

    public void decrContador()
    { 
        System.out.print(" Decrementando contador ");
        int novoValor = valor - 1;
        System.out.println(", novo valor e: " + novoValor);
        valor = novoValor; 
    } 
}
