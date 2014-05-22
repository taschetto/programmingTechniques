package threaddemo1_contadorsimples;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class App {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(2);

        Contador c1 = new Contador("Cont1");
        System.out.println("Disparando a thread 1");
        executor.execute(c1);
        System.out.println("Disparando a thread 2");
        executor.execute(new Contador("Cont2"));
        System.out.println("O main continua executando");
        double x = 0;
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 1000; j++) {
                x = Math.sqrt(i * j);
            }
            System.out.println("Fazendo contas: " + x);
        }
        System.out.println("Fim do main");
        executor.shutdownNow();
    }
}
