package ClassiQuarte.BI.Esercizi.StazioneAlternativeVersion;

public class Stazione {
    private String name;
    private Binario[] binari;

    public Stazione(String name, int numeroBinario) {
        //TODO: fare a case l'implementazione
        this.name = name;
        binari = new Binario[numeroBinario];
        //CreaBinari()
    }

    public Stazione(String name, Binario[] binari) {
        this.name = name;
        this.binari = binari;
    }

    public synchronized Binario arrivaTreno(Treno treno) throws InterruptedException {
        //se tuytti i binari sono occupati -> wait()
        while (AreAllPlatformsOccupied()) wait();
        // assegna il PRIMO binario libero al treno.
        Binario binarioAssegnato = TrovaPrimoBinarioLibero();
        binarioAssegnato.setOccupato(true);

        return binarioAssegnato;
    }

    public synchronized void parteTreno(Binario binarioDaLiberare) {
        // libera il binario occupato da un treno e sveglia i treni in atttesa
        binarioDaLiberare.setOccupato(false);
        notifyAll();
    }

    private boolean AreAllPlatformsOccupied() {
        for (int i = 0; i < binari.length; i++) {
            if (!binari[i].isOccupato()) return false;
        }
        return true;
    }

    private Binario TrovaPrimoBinarioLibero() {
        for (int i = 0; i < binari.length; i++) {
            if (!binari[i].isOccupato()) return binari[i];
        }
        return null;
    }

}
