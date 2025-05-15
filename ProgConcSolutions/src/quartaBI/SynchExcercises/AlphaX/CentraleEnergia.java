package quartaBI.SynchExcercises.AlphaX;

import java.util.Random;

public class CentraleEnergia extends Thread {

    private static final int MAX_IMPULSES = 10;
    private final MagazzinoStazione magazzino;

    private Random r;

    public CentraleEnergia(MagazzinoStazione magazzino) {
        setName("SpaceProd");
        this.magazzino = magazzino;

        this.r = new Random();
    }

    @Override
    public void run() {
        for (int i = 0; i < MAX_IMPULSES; i++) {
            int impulse = r.nextInt(1, 100);
            try {
                magazzino.sendImpulse(impulse);
                Thread.sleep(400);
            } catch (InterruptedException e) {
                System.out.println(getName() + " interrotto.");
                break;
            }
        }
    }
}
