package threads;

import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumer {

    private final Queue<Integer> queue = new LinkedList<>();
    private final int CAPACITY = 5;

    public synchronized void produce(int value) throws InterruptedException {
        while (queue.size() == CAPACITY) {
            wait(); // wait if buffer full
        }
        queue.add(value);
        System.out.println("Produced: " + value);
        notifyAll(); // wake up consumers
    }

    public synchronized int consume() throws InterruptedException {
        while (queue.isEmpty()) {
            wait(); // wait if buffer empty
        }
        int value = queue.poll();
        System.out.println("Consumed: " + value);
        notifyAll(); // wake up producers
        return value;
    }
}
