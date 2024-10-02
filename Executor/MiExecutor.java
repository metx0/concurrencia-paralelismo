package Executor;

import java.util.concurrent.Executor;

public class MiExecutor implements Executor {
    @Override
    public void execute(Runnable r) {
        // Crear un hilo para ejecutar el runnable
        new Thread(r).start();
    }
}
