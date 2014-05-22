package threaddemo9_contadorcomsemaforo;

import java.util.concurrent.*;

public class TesteContadorSemaforo
{
    public static void main(String args[])
    {
        ContadorSemaforo c = new ContadorSemaforo();
        ExecutorService executor = Executors.newFixedThreadPool(4);
        executor.execute(new ThreadContadorSemaforo(c));
        executor.execute(new ThreadContadorSemaforo2(c));
        executor.execute(new ThreadContadorSemaforo(c));
        executor.execute(new ThreadContadorSemaforo2(c));
        executor.shutdown();
    }
}
