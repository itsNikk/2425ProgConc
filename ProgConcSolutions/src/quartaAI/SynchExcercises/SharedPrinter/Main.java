package quartaAI.SynchExcercises.SharedPrinter;

import java.util.ArrayList;

public class Main {
    private static final int MAX_THREADS = 10;

    public static void main(String[] args) throws InterruptedException {
        Printer p = new Printer();
        ArrayList<Thread> printerThreads = new ArrayList<>();
        long startTime = System.currentTimeMillis();

        for (int i = 0; i < MAX_THREADS; i++) {
            printerThreads.add(new PrinterThread("PT-" + (i + 1), p));
        }

        for (Thread t : printerThreads) t.start();
        for (Thread t : printerThreads) t.join();

        System.out.println("Sono stati stampati " + p.getDocsPrintedCount() + " documenti");
        long endTime = System.currentTimeMillis() - startTime;
        System.out.println("Tempo di esecuzione: " + endTime + "ms.");
    }
}
