package quartaAI.SynchExcercises.ProdConsIntro;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        SharedResource sharedResource =
                new SharedResource(3);
        Producer p = new Producer(sharedResource);
        Consumer c = new Consumer(sharedResource);
        p.start();
        c.start();

        // tutti i metodi di attesa sollevano la IneterruptedException
        p.join();
        c.join();

        System.out.println("== END ==");
    }
}
