package producer_consumer;

import java.util.Random;

public class Producer extends Thread {
    private DataStream stream;

    Producer(DataStream stream){
        this.stream = stream;
    }

    @Override
    public void run() {
        while (true){
            char c = (char) (new Random().nextInt(26)+'a');
            stream.pushData(String.valueOf(c));
        }

    }
}
