package quartaBI.SynchExcercises.ProdConsImplV1;

public class Main {
    public static void main(String[] args) {
        //Problema ProdCons
        // Entità coinvolte:
        // Produttore
        //Consumatore
        //RisorsaCondivisa Limitata
        Buffer buffer = new Buffer(10);
        Prod prod = new Prod(buffer);
        Cons cons = new Cons(buffer);


    }
}
