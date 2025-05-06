package quartaBI.SynchExcercises.ProdConsImplV1;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        //Problema ProdCons
        // Entità coinvolte:
        // Produttore
        //Consumatore
        //RisorsaCondivisa Limitata
        Buffer buffer = new Buffer(5);
        Prod prod = new Prod(buffer);
        Cons cons = new Cons(buffer);

        prod.start();
        cons.start();

        prod.join();
        cons.join();

        System.out.println("=== END ===");
    }
}
