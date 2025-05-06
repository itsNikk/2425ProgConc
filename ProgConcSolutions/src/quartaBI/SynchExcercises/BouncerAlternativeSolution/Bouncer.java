package ClassiQuarte.BI.Esercizi.BouncerAlternativeSolution;

public class Bouncer {
    private int capacitaMassima;
    private int personeInterno;

    public Bouncer(int capacitaMassima) {
        this.capacitaMassima = capacitaMassima;
        personeInterno = 0;
    }

    public synchronized void enterClient(Client clientThread) throws InterruptedException {
        //if(eta < 18) Thread.currentThread().interrupt();
        if (clientThread.getEta() < 18) {
            clientThread.interrupt();
            return;
        }

        while (personeInterno >= capacitaMassima) wait();

        personeInterno++;
        System.out.println(clientThread.getName() + " entra nel locale. Persone all'interno: " + personeInterno);
    }

    public synchronized void exitClient(Client client) {
        personeInterno--;
        notifyAll();

        System.out.println(client.getName() + " esce. Prsone interno: " + personeInterno);
    }
}
