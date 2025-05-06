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
        if (buffer.size() == size) {
            System.out.println(
                    Thread.currentThread().getName() + " attende. Vettore pieno (" + buffer.size() + ")");
            wait();
        }

        buffer.add(elem);
        System.out.println(
                Thread.currentThread().getName() + " ha aggiunto: " + elem + ". (" + buffer.size() + ")");
        notify();
    }

    public synchronized Integer getElement() throws InterruptedException {
        if (buffer.isEmpty()) {
            System.out.println(Thread.currentThread().getName() + " attende. Array Vuoto (" + buffer.size() + ")");
            wait();
        }

        Integer elemToRemove = buffer.remove(0);
        System.out.println(Thread.currentThread().getName() + " consuma " + elemToRemove + ". (" + buffer.size() + ")");
        notify();
        return elemToRemove;
    }

}
