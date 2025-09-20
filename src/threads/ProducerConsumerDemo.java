package threads;

public class ProducerConsumerDemo {

        public static void main(String[] args) {
            ProducerConsumer buffer = new ProducerConsumer();

            // Producer
            Thread producer = new Thread(() -> {
                int i = 1;
                try {
                    while (true) {
                        buffer.produce(i++);
                        Thread.sleep(500);
                    }
                } catch (InterruptedException e) { e.printStackTrace(); }
            });

            // Consumer
            Thread consumer = new Thread(() -> {
                try {
                    while (true) {
                        buffer.consume();
                        Thread.sleep(1000);
                    }
                } catch (InterruptedException e) { e.printStackTrace(); }
            });

            producer.start();
            consumer.start();
        }

}
