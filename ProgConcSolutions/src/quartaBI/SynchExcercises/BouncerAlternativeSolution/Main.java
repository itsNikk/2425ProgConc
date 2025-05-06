package quartaBI.SynchExcercises.BouncerAlternativeSolution;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        final int NUM_THREAD = 20;

        Bouncer bouncer = new Bouncer(5);
        ArrayList<Client> clients = new ArrayList<>();

        for (int i = 0; i < NUM_THREAD; i++)
            clients.add(new Client("Client#" + (i + 1), 18, bouncer));

        for (Client client : clients) client.start();

        for (Client client : clients) client.join();

        System.out.println("Il locale chiude :)");
    }
}
