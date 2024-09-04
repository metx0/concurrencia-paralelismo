/* 
 * Esta clase representa un hilo que imprime los números
 * impares del 1 al 10
 * 
 * @author Miguel Ángel Alejandro Torruco
 */

public class HiloRunnable implements Runnable {
    
    @Override
    public void run() {
        String nombre = Thread.currentThread().getName();

        System.out.println("Hola desde: " + nombre);

        for (int i = 1; i < 10; i += 2) {
            System.out.println(nombre + " : " + i);
        }

        System.out.println(nombre + " terminado");
    }    
}
