package threaddemo9_contadorcomsemaforo;

import java.util.concurrent.*;

public class ContadorSemaforo
{
    private int valor; 
    private final Semaphore semaforo = new Semaphore(1, true);

    public ContadorSemaforo()
    {
        valor = 0;
    }
    
    public void incrContador() throws InterruptedException
    {
        try
        {
            semaforo.acquire();
            System.out.print(" Incrementando contador ");
            int novoValor = valor + 1;
            System.out.println(" , novo valor e: " + novoValor);
            valor = novoValor;
        }
        finally
        {
            semaforo.release();
        }
    } 

    public void decrContador() throws InterruptedException
    { 
        try
        {
            semaforo.acquire();
            System.out.print(" Decrementando contador ");
            int novoValor = valor - 1;
            System.out.println(", novo valor e: " + novoValor);
            valor = novoValor;
        }
        finally
        {
            semaforo.release();
        }
    } 
}
