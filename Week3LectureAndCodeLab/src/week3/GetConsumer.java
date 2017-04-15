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
        int i = quantity;
        while(i > 0) {
            System.out.println("GET: " + Thread.currentThread().getName() + " " + bucket.getToken().toString());
            i--;
        }
    }
}
