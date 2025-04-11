package quartaAI.SynchExcercises.IntroCounter;

public class Counter {
    private double value;

    public Counter() {
        this.value = 0;
    }

    public void add(double amount) {
        this.value += amount;
    }


    public double getValue() {
        return value;
    }
}
