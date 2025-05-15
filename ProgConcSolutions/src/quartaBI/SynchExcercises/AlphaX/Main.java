package quartaBI.SynchExcercises.AlphaX;

public class Main {
    private static final int MAX_IMPULSES = 5;

    public static void main(String[] args) throws InterruptedException {
        MagazzinoStazione magazzinoStazione = new MagazzinoStazione(MAX_IMPULSES);
        CentraleEnergia centraleEnergia = new CentraleEnergia(magazzinoStazione);
        Astronave astronave = new Astronave(magazzinoStazione);

        System.out.println("=== MISSIONE SPAZIALE AVVIATA ===");
        centraleEnergia.start();
        astronave.start();
        centraleEnergia.join();
        astronave.join();
        System.out.println("=== MISSIONE SPAZIALE TERMINATA ===");
    }
}
