package threaddemo8_contadorsemsincronismo;

public class ThreadContador2 implements Runnable
{
    private Contador contador;
    
    public ThreadContador2(Contador c)
    {
        contador = c;
    }
    
    public void run()
    {
            for(int i=1; i<= 100; i++)
            {
                contador.decrContador();
            }
    }
}
