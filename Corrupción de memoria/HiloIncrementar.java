/* 
 * El hilo tiene la referencia a una instancia de Contador
 * y cuando es ejecutado llama al método incrementar del contador
 */
public class HiloIncrementar implements Runnable {
    private Contador cont;

    public HiloIncrementar(Contador cont) {
        this.cont = cont;
    }

    @Override
    public void run() {
        cont.incrementar();
    }    
}
