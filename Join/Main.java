package Join;

import java.time.Duration;

/* 
 * Ejemplo de cómo usar Thread.join(), que sirve 
 * para esperar a que un hilo termine su ejecución
 * 
 * Existen varias sobrecargas de join, que hacen cosas distintas
 */

public class Main {
    public static void main(String[] args) throws InterruptedException {
        // Instanciamos la interfaz Runnable usando una función lambda
        Thread t = new Thread(() -> {
            System.out.println("Inicio del hilo");

            try {
                Thread.sleep(Duration.ofSeconds(3));
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }

            System.out.println("Fin del hilo");
        });

        t.start();

        // ¿Qué pasa si queremos ejecutar instrucciones solo cuando el hilo haya terminado?

        // Congela la ejecución del hilo principal hasta que el hilo t termine
        // t.join();
        
        // Podemos especificar un tiempo límite de espera, tras el cual se reaunuda la ejecución del hilo actual
        // Esto sirve por si el hilo al que estamos esperando con join() tarda demasiado
        // t.join(1000);

        // boolean status = t.join(Duration.ofSeconds(10));

        while (!t.join(Duration.ofSeconds(1))) {
            System.out.println("El hilo t sigue en ejecución");
        }

        System.out.println("Fin del hilo principal");
    }
}
