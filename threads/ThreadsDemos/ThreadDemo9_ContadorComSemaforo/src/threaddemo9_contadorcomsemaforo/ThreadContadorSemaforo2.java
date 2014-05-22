package threaddemo9_contadorcomsemaforo;

public class ThreadContadorSemaforo2 implements Runnable
{
    private ContadorSemaforo contador;
    
    public ThreadContadorSemaforo2(ContadorSemaforo c)
    {
        contador = c;
    }
    
    public void run()
    {
        try
        {
            for(int i=1; i<= 100; i++)
            {
                contador.decrContador();
            }
        }
        catch(InterruptedException e)
        {}
    }
}
