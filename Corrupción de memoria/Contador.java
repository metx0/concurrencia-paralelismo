/* 
 * La clase posee un entero inicializado en 0 y un 
 * método para incrementarlo en uno
 */
public class Contador {
    private int valor = 0;

    /* 
     * La palabra clave "synchronized" hace que solo un hilo pueda
     * estar ejecutando esta porción de código en un instante determinado
     * Se dice que "synchronized" invoca al monitor de la clase en cuestión, 
     * Contador en este caso
     * Esto evita que haya corrupción de memoria, porque se impide que 2 hilos
     * ejecuten simultáneamente la modificación a la variable "valor"
     */
    public synchronized void incrementar() {
        // Podríamos hacer this.valor++, pero elegimos lo siguiente
        int temp = valor;
        temp++;
        this.valor = temp;
    }

    public int getValor() {
        return this.valor;
    }
}
