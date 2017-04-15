package week3;

/**
 * Created by liukx08 on 4/15/2017.
 */
public class PutWorker implements Runnable {
    private Bucket bucket;
    private int task;

    public PutWorker(int task, Bucket bucket) {
        this.bucket = bucket;
        this.task = task;
    }
    @Override
    public void run() {
        int i = 0;
        while(i < task) {
            bucket.putToken(new Token(i,"Token made by " + Thread.currentThread().getName()));
            System.out.println("PUT: " + Thread.currentThread().getName() + " " + i++);
        }
    }
}
