import java.util.concurrent.*;

/**
 * Created by liukx08 on 4/26/2017.
 */
public class TestPool {
    public static class MyRunnable implements Runnable {
        @Override
        public void run() {
            int res = 0;
            for(int i = 0; i < 10; i++) {
                res += i;
            }
            System.out.println("Runnable: " + res);
        }
    }

    public static class MyCallable implements Callable<Integer> {
        @Override
        public Integer call() {
            int res = 0;
            for(int i = 0; i < 10; i++) {
                res += i;
            }
            return res;
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService singleThreadPool = Executors.newSingleThreadExecutor();
        Future<?> future1 = singleThreadPool.submit(new MyRunnable());
        Future<Integer> future2 = singleThreadPool.submit(new MyCallable());
        System.out.println("Runnable Future: " + future1.get());
        System.out.println("Callable Future: " + future2.get());
        singleThreadPool.execute(new MyRunnable());
        singleThreadPool.shutdown();
    }
}
