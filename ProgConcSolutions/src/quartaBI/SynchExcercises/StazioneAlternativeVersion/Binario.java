package ClassiQuarte.BI.Esercizi.StazioneAlternativeVersion;

public class Binario {
    private int numeroBinario;
    private boolean occupato;

    public Binario(int numeroBinario, boolean occupato) {
        this.numeroBinario = numeroBinario;
        this.occupato = occupato;
    }

    public int getNumeroBinario() {
        return numeroBinario;
    }

    public void setNumeroBinario(int numeroBinario) {
        this.numeroBinario = numeroBinario;
    }

    public boolean isOccupato() {
        return occupato;
    }

    public void setOccupato(boolean occupato) {
        this.occupato = occupato;
    }
}
