package week3;


/**
 * Created by liukx08 on 4/14/2017.
 */
public class JoinTest {
    public static void main(String[] args) {
        MyThread thread1 = new MyThread();
        MyThread thread2 = new MyThread();
        thread1.start();
/*        try {
            thread1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        thread2.start();
    }
}
