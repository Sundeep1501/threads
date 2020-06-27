package producer_consumer;

public class DataStream {

    private String data;

    synchronized void pushData(String data){
        while(!isEmpty()){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.data = data;
        notify();
    }

    synchronized String pullData(){
        while (isEmpty()){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        String temp = data;
        data = null;
        notify();
        return temp;
    }

    synchronized boolean isEmpty(){
        return data == null;
    }
}
