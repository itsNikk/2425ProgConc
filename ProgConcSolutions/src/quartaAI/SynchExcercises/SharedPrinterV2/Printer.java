package quartaAI.SynchExcercises.SharedPrinterV2;

import java.util.Random;
import java.util.concurrent.Semaphore;

//Di SOLITO, le risorse condivise NON sono thread
public class Printer {

    private Semaphore semaphore;
    private int docsInQueue;
    private int docsPrinted;

    private Random r;

    public Printer() {
        this.semaphore = new Semaphore(1);
        this.r = new Random();
    }

    public void print(Document doc) {
        System.out.println(Thread.currentThread().getName() + " cerca di stampare..." + doc.getTitle() + "...");
        try {
            semaphore.acquire();
            System.out.println(Thread.currentThread().getName() + " inizia la stampa di " + doc.getTitle() + "...");
            Thread.sleep(r.nextInt(500, 1500));
            docsPrinted++;
            System.out.println(Thread.currentThread().getName() + " finisce la stampa di " + doc.getTitle() + "...");
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + " interrotto.");
        }
        //PERCHE' è meglio qui?
        semaphore.release();
    }
}
