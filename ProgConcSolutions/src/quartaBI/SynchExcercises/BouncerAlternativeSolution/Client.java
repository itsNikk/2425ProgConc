package ClassiQuarte.BI.Esercizi.BouncerAlternativeSolution;

public class Client extends Thread {
    private int eta;

    private Bouncer bouncer;

    public Client(String name, int eta, Bouncer bouncer) {
        // super(name) = setName(name)
        super(name);
        this.eta = eta;
        this.bouncer = bouncer;
    }

    @Override
    public void run() {
        try {
            // cerca di entrare nel locale
            bouncer.enterClient(this);
            // se entra, aspetta un po'
            sleep((int) (Math.random() * 5000) + 2000);
            // esce
            bouncer.exitClient(this);

        } catch (InterruptedException e) {
            System.out.println(getName() + " interrotto.");
        }
    }

    public int getEta() {
        return eta;
    }
}
