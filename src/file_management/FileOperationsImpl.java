package file_management;

public class FileOperationsImpl implements FileAccessOperations {

    /* When count is
     * (equals 0) -> File is free, no thread is accessing it (Write and read request is possible)
     * (greater than 0) -> File is being read by #count of threads.(Reads are still possible. No write)
     * (lesser than 0) -> File is in write mode.(Write/Read is not possible)
     *
     * So basically, the file can read by multiple threads at a time.
     * But only one thread can write at a given time.
     */
    private int count = 0;

    @Override
    synchronized public void requestReadAccess() {
        while(count < 0){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        count++;
    }

    @Override
    synchronized public void releaseReadAccess() {
        if(count > 0){
            count--;
        }
        if(count == 0){
            notifyAll();
        }
    }

    @Override
    synchronized public void requestWriteAccess() {
        while(count != 0){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        count--;
    }

    @Override
    synchronized public void releaseWriteAccess() {
        count = 0;
        notifyAll();
    }
}
