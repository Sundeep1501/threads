package producer_consumer;

public class Consumer extends Thread {

    private DataStream stream;

    Consumer(DataStream stream){
        this.stream = stream;
    }

    @Override
    public void run() {
        while (true){
            System.out.println("Consumed: "+ stream.pullData());
        }
    }
}
