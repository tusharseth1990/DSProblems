package threads;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumerBQ {
    public static void main(String[] args) {
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(5);

        Runnable producer = () -> {
            int i = 1;
            try {
                while (true) {
                    queue.put(i);
                    System.out.println("Produced: " + i);
                    i++;
                    Thread.sleep(500);
                }
            } catch (InterruptedException e) { e.printStackTrace(); }
        };

        Runnable consumer = () -> {
            try {
                while (true) {
                    int value = queue.take();
                    System.out.println("Consumed: " + value);
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) { e.printStackTrace(); }
        };

        new Thread(producer).start();
        new Thread(consumer).start();
    }

}
