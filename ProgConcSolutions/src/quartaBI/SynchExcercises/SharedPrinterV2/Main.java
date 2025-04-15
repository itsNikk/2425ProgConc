package quartaBI.SynchExcercises.SharedPrinterV2;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        long startTime = System.currentTimeMillis();

        Printer p = new Printer();
        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < 10; i++) threads.add(new PrinterThread(p));
        for (Thread t : threads) t.start();


        for (Thread t : threads) t.join();

        long endTime = System.currentTimeMillis() - startTime;
        System.out.println("EXEC TIME: " + endTime + "ms.");

    }
}
