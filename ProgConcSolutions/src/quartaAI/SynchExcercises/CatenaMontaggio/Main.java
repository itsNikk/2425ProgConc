package quartaAI.SynchExcercises.CatenaMontaggio;

import java.util.ArrayList;

public class Main {

    private final static int MAX_THREAD = 2;

    public static void main(String[] args) throws InterruptedException {
        CatenaMontaggio catenaMontaggio = new CatenaMontaggio();
        ArrayList<Operaio> operai = new ArrayList<>();

        for (int i = 0; i < MAX_THREAD; i++) operai.add(new Operaio("Operaio " + (i + 1), catenaMontaggio));
        for (Operaio operaio : operai) operaio.start();
        for (Operaio operaio : operai) operaio.join();

        System.out.println("Pipeline terminata");
    }
}
