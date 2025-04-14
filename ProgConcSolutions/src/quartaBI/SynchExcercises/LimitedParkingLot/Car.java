package quartaBI.SynchExcercises.LimitedParkingLot;

public class Car implements Runnable {

    private final ParkingLot parkingLot;

    public Car(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    @Override
    public void run() {
        parkingLot.entra(Thread.currentThread());
    }
}
