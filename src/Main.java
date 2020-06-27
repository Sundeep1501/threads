import util.Worker;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        System.out.println("Main Thread Started");
        Random random = new Random();

        Worker worker = new Worker(()-> {
            System.out.println("Thread 1 Started");
            try {
                Thread.sleep(random.nextInt(5)*1000);
            } catch(InterruptedException e){
                e.printStackTrace();
            }
            System.out.println("Thread 1 Stopped");
        });

        Worker worker2 = new Worker(()-> {
            System.out.println("Thread 2 Started");
            try {
                Thread.sleep(random.nextInt(5)*1000);
            } catch(InterruptedException e){
                e.printStackTrace();
            }
            System.out.println("Thread 2 Stopped");
        });

        worker.execute();
        worker2.execute();

        try {
            // join the group, we'll take care and wait for you to complete
            worker.join();
            worker2.join();
        } catch(InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("Main Thread Stopped");
    }
}
