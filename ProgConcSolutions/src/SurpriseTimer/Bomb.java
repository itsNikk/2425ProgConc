package SurpriseTimer;

public class Bomb extends Thread {


    public Bomb() {
    }

    @Override
    public void run() {
        for (int i = 10; i > 0; i--) {
            System.out.println("Countdown: " + i);
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(getName() + " interrotto.");

                return;
            }
        }

        System.out.println("BOOM!");
    }
}
