package quartaBI.SynchExcercises.AlphaX;

public class Astronave extends Thread {

    private static final int IMPULSES_TO_TAKE = 10;
    private final MagazzinoStazione magazzinoStazione;

    public Astronave(MagazzinoStazione magazzinoStazione) {
        setName("SpaceCons");
        this.magazzinoStazione = magazzinoStazione;
    }

    @Override
    public void run() {
        for (int i = 0; i < IMPULSES_TO_TAKE; i++) {
            try {
                magazzinoStazione.take();
                Thread.sleep(600);
            } catch (InterruptedException e) {
                System.out.println(getName() + " interrotto");
                break;
            }
        }
    }
}
