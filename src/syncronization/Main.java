package syncronization;

import util.Worker;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Account account = new Account("Sundeep", 350.47);

        for (int i = 0; i < 100; i++) {
            Worker worker = new Worker(()-> {
                try {
                    Thread.sleep(new Random().nextInt(10));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                account.deposit(20);
            });
            worker.execute();
            try {
                worker.join();
            } catch (InterruptedException e){
                e.printStackTrace();
            }

            worker = new Worker(()-> {
                try {
                    Thread.sleep(new Random().nextInt(10));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                account.withdrawal(20);
            });
            worker.execute();
            try {
                worker.join();
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        // expecting same balance as initial deposit
        System.out.println(account.toString());
    }

}