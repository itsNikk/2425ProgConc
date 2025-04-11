package quartaAI.SynchExcercises.IntroCounter;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Counter c = new Counter();
        CounterThread t1 = new CounterThread(c);
        CounterThread t2 = new CounterThread(c);

        //t1.run(); //LA MORTE!
         t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Valore: " + c.getValue());
    }
}

