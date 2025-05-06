package quartaBI.SynchExcercises.ProdConsImplV1;

import java.util.Random;

public class Prod extends Thread {

    private Buffer buffer;
    private Random r;


    private static final int MAX_ITER = 10;

    public Prod(Buffer buffer) {
        setName("Prod ");
        this.buffer = buffer;
        this.r = new Random();
    }

    @Override
    public void run() {
        // per 10 volte genera un numero random [2, 20]
        // e mandalo alla risorsa
        for (int i = 0; i < MAX_ITER; i++) {
            try {
                buffer.addElement(r.nextInt(2, 20));
            } catch (InterruptedException e) {
                System.out.println(getName() + " interrotto.");
            }
        }

    }
}
