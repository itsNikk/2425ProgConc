package quartaAI.SynchExcercises.FileStats;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String filePath = "bigFile.csv";
        try {
            FileGenerator.generateRandomFile(filePath, 1000, 10000);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
