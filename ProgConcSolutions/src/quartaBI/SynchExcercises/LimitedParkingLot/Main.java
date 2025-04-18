package quartaBI.SynchExcercises.LimitedParkingLot;

import java.util.ArrayList;

public class Main {
    private static final int MAX_THREAD = 10;
    private static final long OPENING_TIME = 2000;
    private static int maxSlots = 3;

    public static void main(String[] args) throws InterruptedException {
        ArrayList<Thread> cars = new ArrayList<>();
        ParkingLot parkingLot = new ParkingLot(maxSlots);

        for (int i = 0; i < MAX_THREAD; i++) cars.add(new Thread(new Car(parkingLot)));

        for (Thread t : cars) t.start();

        Thread.sleep(OPENING_TIME);
        for (Thread t : cars) t.interrupt();
        System.out.println("Fine della giornata di lavoro, il parcheggio chiude");
    }
}
