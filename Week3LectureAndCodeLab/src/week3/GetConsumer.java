package week3;

/**
 * Created by liukx08 on 4/15/2017.
 */
public class GetConsumer implements Runnable {
    private Bucket bucket;
    private int quantity;

    public GetConsumer(int quantity, Bucket bucket) {
        this.bucket = bucket;
        this.quantity = quantity;
    }

    public void run() {
        for(int i = quantity; i > 0; i--) {
            System.out.println("GET: " + Thread.currentThread().getName() + " " + bucket.getToken().toString());
        }
    }
}
