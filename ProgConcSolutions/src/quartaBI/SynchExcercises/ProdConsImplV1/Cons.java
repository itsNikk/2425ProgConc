package quartaBI.SynchExcercises.ProdConsImplV1;

public class Cons extends Thread {

    private static final int MAX_ITER = 10;
    private Buffer buffer;

    public Cons(Buffer buffer) {
        this.buffer = buffer;
        setName("Cons");
    }

    @Override
    public void run() {
        for (int i = 0; i < MAX_ITER; i++) {
            try {
                int val = buffer.getElement();
            } catch (InterruptedException e) {
                System.out.println(getName() + " interrotto.");
            }
        }
    }
}
