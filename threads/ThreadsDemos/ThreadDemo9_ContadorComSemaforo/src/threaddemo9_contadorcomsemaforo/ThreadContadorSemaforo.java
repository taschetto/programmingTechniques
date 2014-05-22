package threaddemo9_contadorcomsemaforo;

public class ThreadContadorSemaforo implements Runnable
{
    private ContadorSemaforo contador;
    
    public ThreadContadorSemaforo(ContadorSemaforo c)
    {
        contador = c;
    }
    
    public void run()
    {
        try
        {
            for(int i=1; i<= 100; i++)
            {
                contador.incrContador();
            }
        }
        catch(InterruptedException e)
        {}
    }
}
