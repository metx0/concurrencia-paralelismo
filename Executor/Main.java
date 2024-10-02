package Executor;

import java.util.concurrent.*;
import java.time.Duration;

public class Main {
    /**
     * Esta clase representa una tarea que toma cierta cantidad de tiempo en realizarse
     * La ejecución se simula con Thread.sleep, y la duración se especifica con una unidad de tiempo
     * y la cantidad como tal 
     */
    static class TareaConTiempo implements Runnable {
        String id;
        long duracion;
        TimeUnit unidad;

        public TareaConTiempo(String id, long duracion, TimeUnit unidad) {
            this.id = id;
            this.duracion = duracion;
            this.unidad = unidad;
        }

        @Override
        public void run() {
            System.out.println(id + " inicia, con thread id: " + Thread.currentThread().threadId());

            try {
                Thread.sleep(Duration.of(duracion, unidad.toChronoUnit()));
                System.out.println(id + " termina");
            } catch (InterruptedException e) {
                System.out.println(id + " interrumpida antes de finalizar");
            }
        }
    }

    public static void main(String[] args) {
        // Instanciamos un ExecutorService que ejecuta las tareas en mono hilo
        ExecutorService es = Executors.newSingleThreadExecutor();
        es.submit(new TareaConTiempo("Tareita", 2, TimeUnit.SECONDS));
        es.submit(new TareaConTiempo("Tareita1", 2, TimeUnit.SECONDS));
        es.submit(new TareaConTiempo("Tareita2", 2, TimeUnit.SECONDS));
        es.submit(new TareaConTiempo("Tareita3", 1, TimeUnit.SECONDS));
        es.submit(new TareaConTiempo("Tareita4", 3, TimeUnit.SECONDS));
        

        // El executor service continúa ejecutándose aún cuando ya terminó la tarea que se le envió 
        // Tenemos que llamar al método shuwdown() para finalizar la ejecución
        // shuwdown continúa ejecutando las tareas que sigan en ejecución, pero hace que el executor ya no pueda recibir más 
        // tareas a ejecutar
        es.shutdownNow();
        // shuwdownNow() para la ejecución de todas las tareas en marcha (en caso de haber) mandándoles una interrupción

        // Objetivo: lanzar un hilo que sume los números del 1 al 100 y devuelva el resultado
        
    }
}
