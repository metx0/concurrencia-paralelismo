/* 
    Práctica de concurrencia y paralelismo sobre la creación de hilos y sus estados 
    En el programa primero se crean dos hilos, uno que imprime los primeros 10 números pares
    y otro que imprime los primeros 10 números impares.
    Después de que ambos hilos hayan terminado (pasen a estado de TERMINATED), se pone en 
    ejecución un tercer hilo, que imprime cada caracter de una cadena en una línea
    Finalmente se imprime el estado de todos los hilos después de ejecutarse (TERMINATED)

    @author Miguel Ángel Alejandro Torruco
*/

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Muestra del funcionamiento de los hilos");

        HiloUno h1 = new HiloUno();
        h1.setName("Hilo de pares");
        System.out.println("Estado del hilo de pares antes de ejecución: " + h1.getState().name());

        // Una instancia de HiloRunnable será pasada como argumento al constructor de un thread
        Thread h2 = new Thread(new HiloRunnable());
        h2.setName("Hilo de impares");
        System.out.println("Estado del hilo de impares antes de ejecución: " + h2.getState().name());

        h1.start();
        h2.start();

        System.out.println("Estado del hilo de pares en ejecución: " + h1.getState().name());
        System.out.println("Estado del hilo de impares en ejecución: " + h2.getState().name());

        // Vamos a esperar a la terminación de los 2 hilos y después ejecutamos un tercero
        // Usamos el método join para detener el hilo principal hasta que h1 y h2 finalicen
        h1.join();
        h2.join();

        Thread h3 = new Thread(new HiloCadena("ejecución de hilos"));
        h3.setName("Hilo de caracteres"); 
        h3.start();

        // Esperamos a que h3 finalice para seguir
        h3.join();

        System.out.println("Estado de los hilos después de su ejecución: ");
        System.out.println("Hilo de pares: " + h1.getState().name());
        System.out.println("Hilo de impares: " + h2.getState().name());
        System.out.println("Hilo de caracteres: " + h3.getState().name());
    }
}
