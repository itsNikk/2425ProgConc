package quartaBI.SynchExcercises.ParkingLotSynchronized;

public class ParkingLot {
    private int postiLiberi;

    public ParkingLot(int postiLiberiIniziali) {
        this.postiLiberi = postiLiberiIniziali;
    }

    public synchronized void enter(Car c) {
        System.out.println(c.getName() + " entra nel parcheggio (posti liberi: " + postiLiberi + ")");
        postiLiberi--;
    }

    public synchronized void exit(Car c) {
        System.out.println(c.getName() + " esce dal parcheggio (PL: " + postiLiberi + ")");
        postiLiberi++;
    }

}
