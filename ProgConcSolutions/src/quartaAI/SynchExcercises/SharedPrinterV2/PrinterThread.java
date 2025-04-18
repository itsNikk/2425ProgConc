package quartaAI.SynchExcercises.SharedPrinterV2;

import java.util.ArrayList;
import java.util.Random;

public class PrinterThread extends Thread {

    private Printer printer;
    private ArrayList<Document> docs;

    public PrinterThread(Printer p) {
        this.printer = p;
        this.docs = generateDocs();

    }

    private ArrayList<Document> generateDocs() {
        ArrayList<Document> results = new ArrayList<>();
        int maxDocs = new Random().nextInt(2, 4);
        for (int i = 0; i < maxDocs; i++) {
            results.add(new Document("DOCTITLE:" + (i + 1), "Il testo del doc" + (i + 1)));
        }
        return results;
    }

    @Override
    public void run() {
        for (Document doc : docs) printer.print(doc);
    }
}
