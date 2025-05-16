package quartaAI.SynchExcercises.ProdConsIntro;

public class Consumer extends Thread {

    private SharedResource sharedResource;

    public Consumer(SharedResource sharedResource) {
        super("Consumer");
        this.sharedResource = sharedResource;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            try {
                sharedResource.getValue();
                Thread.sleep(1);
            } catch (InterruptedException d) {
                System.out.println(getName() + " interrotto.");
            }
        }
    }
}
