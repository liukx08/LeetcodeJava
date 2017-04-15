package week3;

/**
 * Created by liukx08 on 4/15/2017.
 */
public class Producer implements Runnable {
    private LockBucket bucket;
    private int task;

    public Producer(int task, LockBucket bucket){
        this.bucket = bucket;
        this.task = task;
    }

    @Override
    public void run() {
        for(int i = 0; i < task; i++) {
            bucket.set("Token made by " + Thread.currentThread().getName());
        }
    }
}
