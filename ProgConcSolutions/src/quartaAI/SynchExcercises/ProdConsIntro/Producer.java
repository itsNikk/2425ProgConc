package quartaAI.SynchExcercises.ProdConsIntro;

public class Producer extends Thread {
    public final int MAX_ITERATIONS = 20;
    private SharedResource sharedResource;

    public Producer(SharedResource sharedResource) {
        //super("Producer"); SAME
        setName("Producer");
        this.sharedResource = sharedResource;
    }

    @Override
    public void run() {
        // per 20 volte genera un numero
        // a ccaso e mettilo nella risorsa
        for (int i = 0; i < MAX_ITERATIONS; i++) {
            int val = (int) (Math.random() * (100 - 1)) + 1;
            try {
                Thread.sleep(500);
                sharedResource.addValue(val);
            } catch (InterruptedException e) {
                System.out.println(getName() + " Interrotto.");
            }
        }
    }
}
