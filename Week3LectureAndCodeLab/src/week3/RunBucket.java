package week3;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liukx08 on 4/15/2017.
 */
public class RunBucket {
    public static void main(String[] args) {
        // Make a bucket
        Bucket myBucket = new Bucket(8, 200, 100);
        // Employ a worker. Good job! Kevin!
        PutWorker workerKevin = new PutWorker(10, myBucket);
        // Here comes our consumer Tom. Welcome!
        GetConsumer consumerTom = new GetConsumer(9, myBucket);
        // 2 managers go to work
        List<Thread> managers = new ArrayList<>();
        for(int i = 0; i < 2; i++) {
            managers.add(new Thread(workerKevin));
        }
        // 3 salesman go to work
        List<Thread> salesmen = new ArrayList<>();
        for(int i = 0; i < 2; i++) {
            salesmen.add(new Thread(consumerTom));
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
