/* 
 * En el main crearemos una instancia de Matriz,
 * y crearemos hilos para que sumen los cuadrados de los elementos de cada fila
 * de esta, y contribuyan a la sumatoria total, garantizando
 * la exclusión mutua al momento de escribir en la variable que almacena
 * la suma total, ya que ese método es sincronizado
 */
public class Main {
    public static void main(String[] args) {
        int filas = 5;
        int columnas = 10;
        Matriz m = new Matriz(filas, columnas);

        m.rellenar(100);
        m.imprimir();

        // Creamos un arreglo de hilos (uno para cada fila)
        Thread[] hilos = new Thread[filas];

        // Inicializamos cada hilo y después los ejecutamos

        for (int i = 0; i < filas; i++) {
            hilos[i] = new Thread(new HiloMatriz(m, i));
        }

        for (int i = 0; i < filas; i++) {
            hilos[i].start();
        }

        // Esperamos a que todos los hilos terminen para imprimir el resultado
        for (int i = 0; i < filas; i++) {
            try {
                hilos[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("La sumatoria total es: " + m.getTotalCuadrados());
    }
}
