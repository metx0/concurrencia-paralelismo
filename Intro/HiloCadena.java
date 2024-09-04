/* 
 * Esta clase representa un hilo que recibe una cadena en su constructor
 * e imprime cada caracter de esa cadena en una línea distinta
 * 
 * @author Miguel Ángel Alejandro Torruco
 */

public class HiloCadena implements Runnable {
    private String texto;

    public HiloCadena(String texto) {
        this.texto = texto;
    }

    @Override
    public void run() {
        String nombre = Thread.currentThread().getName();

        System.out.println("Hola desde: " + nombre);

        for (int i = 0; i < texto.length(); i++) {
            System.out.println(texto.charAt(i));
        }

        System.out.println(nombre + " terminado");
    }
}
