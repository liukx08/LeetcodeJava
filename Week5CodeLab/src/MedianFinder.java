import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by liukx08 on 4/22/2017.
 */
public class MedianFinder {

    private Queue<Integer> low;

    private Queue<Integer> high;

    /** initialize your data structure here. */
    public MedianFinder() {
        // use a max heap to store the lower half of data stream
        low = new PriorityQueue<>((a, b) -> b - a);
        // use a min heap to store the larger half of data stream
        high = new PriorityQueue<>();
    }

    public void addNum(int num) {
        // try add new num into lower half
        low.offer(num);
        // add the largest num from lower half into larger half
        high.offer(low.poll());
        // always keep the lower half has the same size as the larger half or only has one more num
        if(low.size() < high.size()) {
            low.offer(high.poll());
        }
    }

    public double findMedian() {
        // no data at all
        if(low.size() == 0 && high.size() == 0) {
            return 0.0;
        }
        // odd number of nums in total
        if(low.size() > high.size()) {
            return (double)low.peek();
        }
        // even number of nums in total
        return (low.peek() + high.peek()) / 2.0;
    }
}
