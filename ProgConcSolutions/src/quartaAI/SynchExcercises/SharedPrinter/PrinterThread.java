package quartaAI.SynchExcercises.SharedPrinter;

public class PrinterThread extends Thread {

    public static final int DOCS_TO_PRINT = 2;
    private final Printer printer;

    public PrinterThread(String name, Printer printer) {
        super(name);
        this.printer = printer;
    }

    @Override
    public void run() {
        for (int i = 0; i < DOCS_TO_PRINT; i++) printer.print("DOC-" + (i + 1));
    }
}
