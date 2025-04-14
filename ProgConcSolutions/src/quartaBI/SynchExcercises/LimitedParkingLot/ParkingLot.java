package quartaBI.SynchExcercises.LimitedParkingLot;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class ParkingLot {
    private final Semaphore parkingLotSemaphore;
    private final Random r;

    public ParkingLot(int maxSlots) {
        this.parkingLotSemaphore = new Semaphore(maxSlots);
        this.r = new Random();
    }

    public void entra(Thread car) {
        System.out.println(car.getName() + " prova a entrare nel parcheggio");
        try {
            parkingLotSemaphore.acquire();
            System.out.println(car.getName() + " parcheggia. (Posti disponibili: " + parkingLotSemaphore.availablePermits() + ")");
            Thread.sleep(r.nextInt(500, 1500));
            parkingLotSemaphore.release();
            System.out.println(car.getName() + " esce dal parcheggio (Posti disponibili: " + parkingLotSemaphore.availablePermits() + ")");
        } catch (InterruptedException e) {
            System.out.println(car.getName() + " interrotto");
        }
    }


}
