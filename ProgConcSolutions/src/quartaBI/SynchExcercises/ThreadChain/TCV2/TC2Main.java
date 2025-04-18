package quartaBI.SynchExcercises.ThreadChain.TCV2;

public class TC2Main {
    public static void main(String[] args) {
        ChainThread chainThreadA = new ChainThread("Chain Thread A", null);
        ChainThread chainThreadB = new ChainThread("Chain Thread B", chainThreadA);
        ChainThread chainThreadC = new ChainThread("Chain Thread C", chainThreadB);

        chainThreadA.start();
        chainThreadB.start();
        chainThreadC.start();

        try {
            chainThreadB.join();
            chainThreadA.join();
            chainThreadC.join();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Main chiude.");
    }
}
