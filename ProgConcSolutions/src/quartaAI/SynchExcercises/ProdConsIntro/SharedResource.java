package quartaAI.SynchExcercises.ProdConsIntro;

import java.util.ArrayList;
import java.util.List;

public class SharedResource {
    private List<Integer> buffer;
    private final int MAX;

    public SharedResource() {
        this.buffer = new ArrayList<>();
        this.MAX = 10;
    }

    public SharedResource(int capacity) {
        this.buffer = new ArrayList<>();
        this.MAX = capacity;
    }

    //chiamsto solo dal produttore
    public synchronized void addValue(int val) throws InterruptedException {
        if (buffer.size() == MAX) {
            System.out.println(Thread.currentThread().getName() + " aspetta. (" + buffer.size() + ")");
            wait();
        }

        buffer.add(val);
        System.out.println(Thread.currentThread().getName() + " ha inserito " + val + "(" + buffer.size() + ")");
    }

    // cahiamto solo dal consumatore
    public synchronized int getValue() throws InterruptedException {
        if (buffer.isEmpty()) wait();

        int removedVal = buffer.remove(0);
        notify();

        System.out.println(Thread.currentThread().getName() + "  ha ottenuto " + removedVal + "(" + buffer.size() + ")");
        return removedVal;
    }

}
