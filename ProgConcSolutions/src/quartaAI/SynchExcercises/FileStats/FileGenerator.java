package quartaAI.SynchExcercises.FileStats;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class FileGenerator {

    //Just to say "You shouldn't instantiate this class, really."
    private FileGenerator() {
    }

    public static void generateRandomFile(String path, int rowCount, int valuesPerRow) throws IOException {
        Random rand = new Random();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {
            for (int r = 0; r < rowCount; r++) {
                StringBuilder riga = new StringBuilder();

                for (int i = 0; i < valuesPerRow; i++) {
                    // Usa double con due decimali
                    double valore = Math.round(rand.nextDouble() * 10000.0) / 100.0;
                    riga.append(valore);

                    if (i < valuesPerRow - 1) riga.append(",");
                }

                writer.write(riga.toString());
                writer.newLine();
            }
        }

        System.out.println("File generato con successo: " + path);
    }
}
