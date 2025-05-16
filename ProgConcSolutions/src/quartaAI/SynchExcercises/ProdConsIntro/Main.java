package quartaAI.SynchExcercises.ProdConsIntro;

import quartaBI.SynchExcercises.ProdConsImplV1.Cons;

import javax.imageio.metadata.IIOMetadataFormatImpl;
import java.util.ArrayList;

public class Main {

    private static final int MAX_CONS = 10;
    private static final int MAX_PROD = 10;

    public static void main(String[] args) throws InterruptedException {
        SharedResource sharedResource =
                new SharedResource(3);
        ArrayList<Producer> producers = new ArrayList<>();
        ArrayList<Consumer> consumers = new ArrayList<>();

        //creo N consumatori
        for (int i = 0; i < MAX_CONS; i++) consumers.add(new Consumer(sharedResource));
        //creo M Produttori
        for (int i = 0; i < MAX_PROD; i++) producers.add(new Producer(sharedResource));

        for (Producer p : producers) p.start();
        for (Consumer c : consumers) c.start();

        // tutti i metodi di attesa sollevano la IneterruptedException
        for (Consumer c : consumers) c.join();
        for (Producer p : producers) p.join();

        System.out.println("== END ==");
    }
}
