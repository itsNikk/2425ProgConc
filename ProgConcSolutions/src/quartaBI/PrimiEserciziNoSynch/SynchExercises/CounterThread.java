package quartaBI.PrimiEserciziNoSynch.SynchExercises;

import java.util.concurrent.Semaphore;

public class CounterThread extends Thread {

    private Counter c;
    private static final Semaphore sem = new Semaphore(1);

    public CounterThread(Counter c) {
        this.c = c;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            try {
                sem.acquire();
            } catch (InterruptedException e) {
                System.out.println(getName() + " interrotto");
            }
            c.add(1);
            sem.release();
        }
    }
}
