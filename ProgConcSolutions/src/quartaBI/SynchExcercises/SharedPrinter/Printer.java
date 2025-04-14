package quartaBI.SynchExcercises.SharedPrinter;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class Printer {

    private final Semaphore semaphore;
    private final Random r;
    private int docsPrintedCount;

    public Printer() {
        this.semaphore = new Semaphore(1);
        this.r = new Random();
        this.docsPrintedCount = 0;
    }

    public void print(String docToPrint) {
        try {
            System.out.println(Thread.currentThread().getName() + " in attesa di stampare...");
            semaphore.acquire();
            System.out.println(Thread.currentThread().getName() + " sta stampando " + docToPrint + "...");
            Thread.sleep(r.nextInt(500, 1500));
            System.out.println(Thread.currentThread().getName() + " ha finito la stampa di " + docToPrint + "...");
            docsPrintedCount++;
            semaphore.release();
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + " interrotto.");
        }
    }

    public int getDocsPrintedCount() {
        return docsPrintedCount;
    }

}
