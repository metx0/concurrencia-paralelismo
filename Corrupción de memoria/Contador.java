/* 
 * La clase posee un entero inicializado en 0 y un 
 * método para incrementarlo en uno
 */
public class Contador {
    private int valor = 0;

    public void incrementar() {
        int temp = valor;
        temp++;
        this.valor = temp;
    }

    public int getValor() {
        return this.valor;
    }
}
