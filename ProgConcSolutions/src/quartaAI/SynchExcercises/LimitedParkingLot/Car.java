package quartaAI.SynchExcercises.LimitedParkingLot;

public class Car implements Runnable {

    private final ParkingLot parkingLot;

    public Car(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            parkingLot.entra(Thread.currentThread());
        }
    }
}
