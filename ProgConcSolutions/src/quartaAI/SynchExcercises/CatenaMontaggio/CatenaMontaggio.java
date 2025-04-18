package quartaAI.SynchExcercises.CatenaMontaggio;

import java.util.concurrent.Semaphore;

public class CatenaMontaggio {

    private Semaphore assemblaggio;
    private Semaphore collaudo;

    public CatenaMontaggio() {
        this.assemblaggio = new Semaphore(2);
        this.collaudo = new Semaphore(1);
    }

    public void execPipeline(String opName) throws InterruptedException {
        assemblaggio.acquire();
        System.out.println(opName + " inizia assemblaggio");
        Thread.sleep(1000);
        System.out.println(opName + " termina assemblaggio");
        assemblaggio.release();

        collaudo.acquire();
        System.out.println(opName + " inizia collaudo");
        Thread.sleep(1000);
        System.out.println(opName + " termina collaudo");
        collaudo.release();
    }
}
