package threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PrinterService {

    public void printDocuments(int printer, int documents) throws InterruptedException {
        ExecutorService executorServicePrinterPool = Executors.newFixedThreadPool(printer);

        for (int i = 1; i <= documents; i++) {
            int documentId = i;
            executorServicePrinterPool.submit(printEachDocument(documentId));
            Thread.sleep(100);
        }
    }

    private Runnable printEachDocument(int documentId) {

        return () -> {
            System.out.println("Printing document"+documentId);
        };
    }


    public static void main(String[] args) throws InterruptedException {
        PrinterService printerService = new PrinterService();
        printerService.printDocuments(10,1000);

    }
}
