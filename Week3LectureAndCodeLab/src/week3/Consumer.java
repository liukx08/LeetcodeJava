package week3;

/**
 * Created by liukx08 on 4/15/2017.
 */
public class Consumer implements Runnable {
    private LockBucket bucket;
    private int quantity;

    public Consumer(int quantity, LockBucket bucket) {
        this.bucket = bucket;
        this.quantity = quantity;
    }

    @Override
    public void run() {
        for(int i = quantity; i > 0; i--) {
            bucket.get();
        }
    }
}
