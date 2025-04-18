package quartaBI.SynchExcercises.ThreadChain.TCV1;

public class ChainThread extends Thread {

    private final int startNum;
    private final int endNum;
    private ChainThread precedent;

    public ChainThread(String name, int startNum, int endNum, ChainThread previousThread) {
        super(name);
        this.startNum = startNum;
        this.endNum = endNum;
        this.precedent = previousThread;
    }

    @Override
    public void run() {
        if (precedent != null) {
            try {
                precedent.join();
            } catch (InterruptedException e) {
                System.out.println(getName() + " interrotto mentre aspettava la terminazione di " + precedent.getName());
            }
        }
        System.out.println(getName() + " inizia");
        for (int i = startNum; i <= endNum; i++) {
            System.out.println(getName() + ": " + i);
            try {
                sleep(500);
            } catch (InterruptedException e) {
                System.out.println(getName() + " interrotto.");
            }
        }
        System.out.println(getName() + " finisce");
    }
}
