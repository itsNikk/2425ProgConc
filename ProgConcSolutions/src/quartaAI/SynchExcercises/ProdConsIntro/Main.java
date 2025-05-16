package quartaAI.SynchExcercises.ProdConsIntro;

import quartaBI.SynchExcercises.ProdConsImplV1.Prod;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        SharedResource sharedResource =
                new SharedResource(3);
        Producer p = new Producer(sharedResource);

        p.start();

        // tutti i metodi di attesa sollevano la IneterruptedException
        p.join();

        System.out.println("== END ==");
    }
}
