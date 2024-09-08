/* 
 * Ejemplo de cuando en un programa concurrente
 * no se tiene un control del acceso a memoria por parte 
 * de los hilos
 */

public class Main {
    public static void iterar() throws InterruptedException {
        // Ejecutaremos n hilos para ver el resultado final del contador
        Contador c = new Contador();
        int HILOS = 100;

        Thread hilos[] = new Thread[HILOS];

        // Inicializamos los hilos
        for (int i = 0; i < HILOS; i++) {
            hilos[i] = new Thread(new HiloIncrementar(c));
        }

        // Los ponemos en marcha
        for (int i = 0; i < HILOS; i++) {
            hilos[i].start();
        }

        // Tratamos de esperar hasta que todos terminen
        for (int i = 0; i < HILOS; i++) {
            hilos[i].join();
        }

        System.out.println("Resultado final: " + c.getValor());
    }

    public static void main(String[] args) throws InterruptedException {
        /* En algunos casos vamos a ver que el programa imprime "99", ya que 
        dos hilos setean la variable del contador al mismo valor, porque 
        no hay una sincronización entre ellos */

        while (true) {
            iterar();
        }
    }
}