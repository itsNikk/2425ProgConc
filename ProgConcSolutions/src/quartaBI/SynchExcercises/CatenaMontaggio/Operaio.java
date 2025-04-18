package quartaBI.SynchExcercises.CatenaMontaggio;

public class Operaio extends Thread {


    private final CatenaMontaggio catenaMontaggio;

    public Operaio(String name, CatenaMontaggio catenaMontaggio) {
        setName(name);
        this.catenaMontaggio = catenaMontaggio;
    }

    @Override
    public void run() {
        try {
            catenaMontaggio.execPipeline(getName());
        } catch (InterruptedException e) {
            System.out.println(getName() + " interrotto.");
        }
    }
}
