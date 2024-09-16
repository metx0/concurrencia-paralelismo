/* 
 * Esta clase representa un hilo cuya función es sumar los cuadrados
 * de los elementos de una matriz
 */

public class HiloMatriz implements Runnable {
    private Matriz m;
    // La fila de la matriz que el hilo sumará
    private int fila;

    public HiloMatriz(Matriz m, int fila) {
        this.m = m;
        this.fila = fila;
    }

    @Override
    public void run() {
        int[][] matriz = m.getMatriz();
        int sumaCuadradosFila = 0;

        // La fila que el hilo sumará
        int[] filaMatriz = matriz[fila];

        for (int i = 0; i < filaMatriz.length; i++) {
            int elemento = filaMatriz[i];
            int cuadrado = elemento * elemento;
            sumaCuadradosFila += cuadrado;
        }

        String nombre = Thread.currentThread().getName();

        System.out.println(nombre + " terminó de computar la suma: " + sumaCuadradosFila);
        m.contribuirTotal(sumaCuadradosFila);
    }    
}
