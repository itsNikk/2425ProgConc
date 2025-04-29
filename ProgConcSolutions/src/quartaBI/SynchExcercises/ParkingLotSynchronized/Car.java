package quartaBI.SynchExcercises.ParkingLotSynchronized;

import java.util.Random;

public class Car extends Thread {

    private ParkingLot parkingLot;
    private final int MAX_DRIVE_TIME = 1500;
    private final int MAX_PARK_TIME = 2000;

    private Random randomGen;

    public Car(String name, ParkingLot parkingLot) {
        super(name);
        this.parkingLot = parkingLot;
        this.randomGen = new Random();
    }

    @Override
    public void run() {
        /*
        1) guida per un po'
        2) cerca di entrare
        3) ci sta per un po'
        4) esce
         */
        try {
            //1)
            Thread.sleep(randomGen.nextInt(500, MAX_DRIVE_TIME));
            //2)
            parkingLot.enter(this);
            //3)
            Thread.sleep(randomGen.nextInt(500, MAX_PARK_TIME));
            //4)
            parkingLot.exit(this);
        } catch (InterruptedException interruptedException) {
            System.out.println(getName() + " interrotto");
        }
    }
}
