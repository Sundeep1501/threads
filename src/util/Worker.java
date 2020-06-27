package util;

public class Worker extends Thread {


    public Worker(Runnable task){
        super(task);
    }

    public void execute(){
        start();
    }
}
