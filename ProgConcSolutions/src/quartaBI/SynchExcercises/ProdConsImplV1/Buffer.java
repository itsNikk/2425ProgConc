package quartaBI.SynchExcercises.ProdConsImplV1;

import java.util.ArrayList;
import java.util.List;

public class Buffer {
    private List<Integer> buffer;
    private int size;

    public Buffer(int size) {
        this.buffer = new ArrayList<>(size);
        this.size = size;
    }

    public synchronized void addElement(int elem) throws InterruptedException {
        String threadName = Thread.currentThread().getName();
        if (buffer.size() == size) {
            System.out.println(threadName + " attende. Vettore pieno (" + buffer.size() + ")");
            wait();
        }

        buffer.add(elem);
        System.out.println(threadName + " ha aggiunto: " + elem + ". (" + buffer.size() + ")");
        notify();
    }

    public synchronized Integer getElement() throws InterruptedException {
        String threadName = Thread.currentThread().getName();
        if (buffer.isEmpty()) {
            System.out.println(threadName + " attende. Array Vuoto (" + buffer.size() + ")");
            wait();
        }

        Integer elemToRemove = buffer.remove(0);
        System.out.println(threadName + " consuma " + elemToRemove + ". (" + buffer.size() + ")");
        notify();
        return elemToRemove;
    }

}
