package week3;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by liukx08 on 4/14/2017.
 *
 * BlockingQueue
 */
public class Bucket {
    private BlockingQueue<Token> que;
    private int prodRate;   // production rate
    private int consRate;   // consumption rate

    public Bucket(int size, int prate, int crate) {
        que = new ArrayBlockingQueue<>(size);
        prodRate = prate;
        consRate = crate;
    }

    public void putToken(Token token) {
        try {
            Thread.sleep(prodRate);
            que.put(token);
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
    }

    public Token getToken() {
        try {
            Thread.sleep(consRate);
            return que.take();
        } catch(InterruptedException e) {
            e.printStackTrace();
            return null;
        }
    }
}
