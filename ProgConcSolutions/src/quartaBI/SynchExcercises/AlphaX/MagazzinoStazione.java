package quartaBI.SynchExcercises.AlphaX;

import java.util.ArrayList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MagazzinoStazione {

    private int capacity;
    private ArrayList<Integer> buffer;
    private Lock lock;
    private Condition notFull;
    private Condition notEmpty;

    public MagazzinoStazione(int capacity) {
        this.buffer = new ArrayList<>();
        this.capacity = capacity;
        this.lock = new ReentrantLock();
        this.notFull = lock.newCondition();
        this.notEmpty = lock.newCondition();
    }

    public void sendImpulse(int energy) throws InterruptedException {
        lock.lock();

        try {
            while (buffer.size() == capacity) {
                System.out.println("Buffer pieno!" + Thread.currentThread().getName() + " aspetta...");
                notFull.await();
            }
            buffer.add(energy);
            System.out.println("Prodotto valore: " + energy);
            notEmpty.signal();
        } finally {
            lock.unlock();
        }

    }

    public int take() throws InterruptedException {
        lock.lock();
        try {
            while (buffer.isEmpty()) {
                System.out.println("Buffer vuoto. " + Thread.currentThread().getName() + " aspetta...");
                notEmpty.await();
            }

            Integer value = buffer.removeFirst();
            System.out.println("consumato impulso: " + value);
            notFull.signal();
            return value;
        } finally {
            lock.unlock();
        }
    }
}
