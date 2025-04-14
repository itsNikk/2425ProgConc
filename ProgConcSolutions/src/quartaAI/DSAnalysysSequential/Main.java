package quartaAI.DSAnalysysSequential;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        SequentialStatisticalPipeline pipeline = new SequentialStatisticalPipeline();

        long startTime = System.currentTimeMillis();

        List<Integer> data = generateRandomData();

        double mean = pipeline.computeMean(data);
        System.out.println("Mean: " + mean);

        double stddev = pipeline.computeStdDev(data, mean);
        System.out.println("Standard Deviation: " + stddev);

        List<Integer> significant = pipeline.filterSignificant(data, mean, stddev);
        System.out.println("Significant values: " + significant);

        double median = pipeline.computeMedian(significant);
        System.out.println("Median: " + median);

        //int mode = pipeline.computeMode(significant);
        //System.out.println("Mode: " + mode);

        long endTime = System.currentTimeMillis();
        System.out.println("Tempo computazione: " + (endTime - startTime) + "ms");
    }

    private static List<Integer> generateRandomData() {
        List<Integer> theData = new ArrayList<>();
        Random r = new Random();
        for (int i = 0; i < 100_000_000; i++) theData.add(r.nextInt(1000)); //[0,999]
        return theData;
    }
}
