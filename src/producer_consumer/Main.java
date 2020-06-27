package producer_consumer;

public class Main {
    public static void main(String[] args) {

        DataStream stream = new DataStream();
        Producer producer = new Producer(stream);
        Consumer consumer = new Consumer(stream);
        producer.start();
        consumer.start();
        try {
            producer.join();
            consumer.join();
        } catch (InterruptedException e){
            e.printStackTrace();
        }

        System.out.println("Main Terminated");
    }
}
