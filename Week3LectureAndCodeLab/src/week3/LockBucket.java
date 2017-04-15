package week3;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by liukx08 on 4/15/2017.
 */
public class LockBucket {
    private final Lock lock1 = new ReentrantLock();
    private Condition condition1 = lock1.newCondition();
//    private Condition condition2 = lock1.newCondition();

    private Deque<String> bucket;
    private int size;
    private int prodRate;
    private int consRate;

    public LockBucket(int size, int prate, int crate) {
        bucket = new ArrayDeque<>();
        this.size = size;
        prodRate = prate;
        consRate = crate;
    }

    public void set(String val) {
        lock1.lock();
        try {
            while(bucket.size() == size) {
                condition1.await();
            }
            Thread.sleep(prodRate);
            bucket.offer(val);
            System.out.println("PUT: " + val);
            condition1.signalAll();
        } catch(InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock1.unlock();
        }
    }

    public String get() {
        lock1.lock();
        String val = null;
        try {
            while(bucket.isEmpty()) {
                condition1.await();
            }
            Thread.sleep(consRate);
            val = bucket.poll();
            System.out.println("GET: " + Thread.currentThread().getName() + " " + val);
            condition1.signalAll();
        } catch(InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock1.unlock();
        }
        return val;
    }
}
