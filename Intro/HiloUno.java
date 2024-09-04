/*
La diferencia entre this.isInterrupted y Thread.interrupted() es que la 
última limpia el estado (una vez que se interrumpe, ya no se recuerda que fue interrumpido)
Es decir, setea interrupted = false 
*/

/* 
 * Esta clase representa un hilo que imprime los números pares del 1 al 10
 * En cada iteración el hilo se duerme 200 milisegundos
 * 
 * @author Miguel Ángel Alejandro Torruco
 */

public class HiloUno extends Thread {

    @Override
    public void run() {
        String nombre = this.getName();

        System.out.println("Hola desde: " + nombre);

        for (int i = 0; i <= 10; i += 2) {
            System.out.println(nombre + " : " + i);
            
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
        
        /* long i = 0;
        while (true) {
            boolean interrumpido = this.isInterrupted();

            if (interrumpido) {
                System.out.println("El hilo uno ha sido interrumpido");
                return;
            }

            // Recordar periódicamente de la existencia del hilo 
            if (++i == 1000000) {
                i = 0;
                System.out.println("El hilo uno sigue aquí");
            }

        } */

        System.out.println(nombre + " terminado");
    }
}
