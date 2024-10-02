/* 
 * Esta clase representa un hilo cuya función es sumar los cuadrados
 * de los elementos de una matriz
 * Contiene la referencia a un objeto Matriz, y un entero que señala
 * la fila que sumará 
 */

public class HiloMatriz implements Runnable {
    private Matriz m;
    // La fila de la matriz que el hilo sumará
    private int fila;

    public HiloMatriz(Matriz m, int fila) {
        this.m = m;
        this.fila = fila;
    }

    /* 
     * Sumar los cuadrados de los elementos de la fila que le corresponde
     * Obtiene la fila en cuestión como un arreglo e itera sobre ese arreglo
     * para sumar los cuadrados
     */
    @Override
    public void run() {
        int[][] matriz = m.getMatriz();
        // El arreglo que representa la fila que el hilo sumará
        int[] filaMatriz = matriz[fila];

        int sumaCuadradosFila = 0;

        for (int i = 0; i < filaMatriz.length; i++) {
            int elemento = filaMatriz[i];
            int cuadrado = elemento * elemento;
            sumaCuadradosFila += cuadrado;
        }

        String nombre = Thread.currentThread().getName();

        System.out.printf("%s terminó de computar la suma de los cuadrados de la fila %d: %d \n", nombre, this.fila, sumaCuadradosFila);
        m.contribuirTotal(sumaCuadradosFila);
    }    
}
