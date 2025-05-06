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


}
