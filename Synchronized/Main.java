package Synchronized;

// Ejemplo de uso del bloque "synchronized" 
// (la forma de usar synchronized aparte de los métodos sincronizados)

/**
 * En el ejemplo, el recurso compartido es el método "timbre"
 */
public class Main {
    static class Timbre {
        public void timbre() {
            // El siguiente código no está bajo control sincronizado, dado que está fuera del bloque synchronized
            System.out.println("*El hilo se acerca al timbre*");

            // Pasamos como parámetro el identificador del objeto que queremos usar como monitor
            // Si usamos this, estamos usando el monitor de la instancia en cuestión de Timbre
            // En ese caso, tenemos que pasarle la misma instancia a cada hilo que lancemos
            synchronized (this) {
                System.out.print("Ding...");

                try {
                    Thread.sleep(1000);
                    System.out.println("Dong");
                } catch (InterruptedException e) {
                    System.out.println("El hilo ha sido interrumpido en ejecución");
                } 
            }
        }
    }

    static class Visitante implements Runnable {
        Timbre t;

        public Visitante(Timbre t) {
            this.t = t;
        }

        @Override
        public void run() {
            t.timbre();
        }
    }


    public static void main(String[] args) throws InterruptedException {
        Timbre t = new Timbre();

        Thread v1 = new Thread(new Visitante(t));
        Thread v2 = new Thread(new Visitante(t));

        v1.start();
        v2.start();
        v1.join();
        v2.join();

        System.out.println("El hilo principal ha terminado");
    }
}
