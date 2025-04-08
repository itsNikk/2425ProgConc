package quartaBI.PrimiEserciziNoSynch.SynchExercises;

public class Counter {
    private float value;

    public void add(float amount) {
        /*
         * float temp = this.value;
         * temp = temp + amount
         * this.value=temp
         * */
        value += amount;
    }

    //differenza
    //moltiplcazione


    public float getValue() {
        return value;
    }

}
