package threaddemo8_contadorsemsincronismo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author bcopstein
 */
public class ThreadDemo8_ContadorSemSincronismo {
    public static void main(String args[])
    {
        Contador c = new Contador();
        ExecutorService executor = Executors.newFixedThreadPool(4);
        executor.execute(new ThreadContador(c));
        executor.execute(new ThreadContador2(c));
        executor.execute(new ThreadContador(c));
        executor.execute(new ThreadContador2(c));
        executor.shutdown();
    }}
