package week3;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liukx08 on 4/15/2017.
 */
public class RunLockBucket {
    public static void main(String[] args) {
        // Make a bucket
        LockBucket myBucket = new LockBucket(4, 100, 15000);
        // Employ a worker. Good job! Kevin!
        Producer proKevin = new Producer(10, myBucket);
        // Here comes our consumer Tom. Welcome!
        Consumer conTom = new Consumer(9, myBucket);
        // 2 managers go to work
        List<Thread> managers = new ArrayList<>();
        for(int i = 0; i < 2; i++) {
            managers.add(new Thread(proKevin));
        }
        // 3 salesman go to work
        List<Thread> salesmen = new ArrayList<>();
        for(int i = 0; i < 2; i++) {
            salesmen.add(new Thread(conTom));
        }
        // Business starts!
        for(Thread manager : managers) {
            manager.start();
        }
        for(Thread salesman : salesmen) {
            salesman.start();
        }
    }
}
