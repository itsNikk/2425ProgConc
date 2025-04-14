package quartaBI.SynchExcercises.LimitedParkingLot;

import quartaBI.SynchExcercises.SharedPrinter.PrinterThread;

import java.util.ArrayList;

public class Main {
    private static final int MAX_THREAD = 10;
    private static int maxSlots = 3;

    public static void main(String[] args) {
        ArrayList<Thread> cars = new ArrayList<>();
        ParkingLot parkingLot = new ParkingLot(maxSlots);

        for (int i = 0; i < MAX_THREAD; i++) cars.add(new Thread(new Car(parkingLot)));

        for (Thread t : cars) t.start();
    }
}
