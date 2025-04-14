package quartaAI.DSAnalysysSequential;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SequentialStatisticalPipeline {

    public double computeMean(List<Integer> data) {
        double sum = 0;
        for (int num : data) {
            sum += num;
        }
        return sum / data.size();
    }

    public double computeStdDev(List<Integer> data, double mean) {
        double sum = 0;
        for (int num : data) {
            double diff = num - mean;
            sum += diff * diff;
        }
        return Math.sqrt(sum / data.size());
    }

    public List<Integer> filterSignificant(List<Integer> data, double mean, double stddev) {
        List<Integer> filtered = new ArrayList<>();
        for (int num : data) if (Math.abs(num - mean) > stddev) filtered.add(num);
        return filtered;
    }

    public double computeMedian(List<Integer> data) {
        List<Integer> copy = new ArrayList<>(data);
        Collections.sort(copy);
        int size = copy.size();
        if (size % 2 == 0) return (copy.get(size / 2 - 1) + copy.get(size / 2)) / 2.0;
        else return copy.get(size / 2);
    }

    public int computeMode(List<Integer> data) {
        List<Integer> copy = new ArrayList<>(data);
        int maxCount = 0;
        int mode = copy.get(0);

        for (int i = 0; i < copy.size(); i++) {
            int count = 0;
            for (Integer integer : copy) if (integer.equals(copy.get(i))) count++;
            if (count > maxCount) {
                maxCount = count;
                mode = copy.get(i);
            }
        }

        return mode;
    }
}
