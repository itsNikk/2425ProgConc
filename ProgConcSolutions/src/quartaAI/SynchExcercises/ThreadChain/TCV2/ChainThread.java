package quartaAI.SynchExcercises.ThreadChain.TCV2;

public class ChainThread extends Thread {

    private final ChainThread previousThread;

    public ChainThread(String name, ChainThread previousThread) {
        super(name);
        this.previousThread = previousThread;
    }

    @Override
    public void run() {
        try {
            //Se ho un Thread precedente settato, lo devo aspettare
            if (previousThread != null) previousThread.join();

            // Il numero dal quale un Thread T inizia a contare dipende
            // dall'ultimo numero stampato dal Thread precedente nella catena
            int startNumber = previousThread != null ? previousThread.getEndNumber() + 1 : 1;
            int endNumber = startNumber + 9;

            for (int i = startNumber; i <= endNumber; i++) {
                System.out.println(getName() + ": " + i);
                sleep(500);
            }
        } catch (InterruptedException e) {
            System.out.println(getName() + " interrotto.");
        }
    }

    public int getEndNumber() {
        /* <: OPERATORE TERNARIO :>
         * Questa riga -> previousThread != null ? previousThread.getEndNumber() + 10 : 10;
         * Si legge come:
         * if (previousThread != null) {
         * return previousThread.getEndNumber() + 10 }
         * else return 10;
         * */
        return previousThread != null ? previousThread.getEndNumber() + 10 : 10;
    }
}
