package quartaBI.PrimiEserciziNoSynch.SynchExercises;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        //Creare N Thread che vanno a lavorare sul Contare
        Counter c = new Counter();

        ArrayList<Thread> threads = new ArrayList<>();

        //Creo N threads
        for (int i = 0; i < 4; i++) {
            threads.add(new CounterThread(c));
        }

        //Li faccio partire
        for (Thread t : threads) t.start();
        for (Thread t : threads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + " interrotto");
            }
        }

        System.out.println(c.getValue());

    }
}
