/* 
 * La clase representa una matriz (arreglo bidimensional) de enteros, con 
 * una variable que almacena la suma de los cuadrados de todos sus elementos.
 * En el programa se lanzarán hilos para que sumen los cuadrados de cada elemento en 
 * determinada fila, y guarden cada resultado en el entero "totalCuadrados"
 */

import java.util.Random;

public class Matriz {
    private int totalCuadrados;
    private int[][] matriz;
    private int filas, columnas;

    public Matriz(int filas, int columnas) {
        totalCuadrados = 0;
        this.filas = filas;
        this.columnas = columnas;
        matriz = new int[filas][columnas];
    }

    /* 
     * Suma la suma interna de los cuadrados de una fila determinada al total
     * Esto garantiza la exclusión mutua, ya que solo un hilo puede ejecutar este método
     * al mismo tiempo
     * 
     * @param sumaInterna Suma de los cuadrados de los elementos de determinada fila
     */
    public synchronized void contribuirTotal(int sumaInterna) {
        this.totalCuadrados += sumaInterna;
    }

    /* 
     * Inicializa cada elemento del arreglo bidimensional a un 
     * entero aleatorio dentro del rango [0-limite)
     * 
     * @param limite El límite superior del rango de números aleatorios
     */
    public void rellenar(int limite) {
        Random random = new Random();

        // Rellenar la matriz de enteros aleatorios (0-limite)
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                matriz[i][j] = random.nextInt(limite);
            }
        }
    }

    /* 
     * Imprime cada fila de la matriz en una línea distinta, 
     * con espacios entre los elementos
     */
    public void imprimir() {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.print("\n");
        }
    }

    public int[][] getMatriz() {
        return matriz;
    }

    public int getFilas() {
        return filas;
    }

    public int getColumnas() {
        return columnas;
    }

    public int getTotalCuadrados() {
        return totalCuadrados;
    }
}
