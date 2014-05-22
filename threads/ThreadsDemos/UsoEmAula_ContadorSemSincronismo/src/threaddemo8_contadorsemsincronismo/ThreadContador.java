package threaddemo8_contadorsemsincronismo;

public class ThreadContador implements Runnable
{
    private Contador contador;
    
    public ThreadContador(Contador c)
    {
        contador = c;
    }
    
    public void run()
    {
            for(int i=1; i<= 100; i++)
            {
                contador.incrContador();
            }
    }
}
