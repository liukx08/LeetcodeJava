package week3;

/**
 * Created by liukx08 on 4/15/2017.
 */
public class DeadLock {
    String lock1 = new String("");
    String lock2 = new String("");

    class Thread1 extends Thread {
        @Override
        public void run() {
            // synchronized block
            synchronized (lock1) {
                try {
                    Thread.sleep(100);
                } catch(InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lock2) {
                    System.out.println("Thread1 got lock2!");
                }
            }
        }
    }

    class Thread2 extends Thread {
        @Override
        public void run() {
            synchronized (lock2) {
                try {
                    Thread.sleep(100);
                } catch(InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lock1) {
                    System.out.println("Thread2 got lock1!");
                }
            }
        }
    }

    public static void main(String[] args) {
        DeadLock demo = new DeadLock();
        Thread1 thread1 = demo.new Thread1();
        Thread2 thread2 = demo.new Thread2();
        thread1.start();
        thread2.start();
    }
}
