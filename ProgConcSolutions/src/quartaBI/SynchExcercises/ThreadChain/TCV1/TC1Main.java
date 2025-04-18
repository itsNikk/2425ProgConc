package quartaBI.SynchExcercises.ThreadChain.TCV1;

public class TC1Main {
    public static void main(String[] args) {
        ChainThread ta = new ChainThread("Thread A", 1, 6, null);
        ChainThread tb = new ChainThread("Thread B", 1, 6, ta);
        ChainThread tc = new ChainThread("Thread C", 1, 6, tb);

        ta.start();
        tb.start();
        tc.start();

    }
}
