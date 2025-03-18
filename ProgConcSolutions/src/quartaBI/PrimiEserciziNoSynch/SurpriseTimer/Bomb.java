package quartaBI.PrimiEserciziNoSynch.SurpriseTimer;

public class Bomb implements Runnable {
    @Override
    public void run() {
        for (int i = 10; i >= 0; i--) {
            System.out.println("💣 Countdown: " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + " disinnescata.");
                //Cosa sarebbe successo se si fosse usato break?
                return;
            }
        }
        System.out.println("💥 BOOM!");
    }
}
