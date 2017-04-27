import java.util.ArrayList;
import java.util.List;

/**
 * Created by liukx08 on 4/27/2017.
 */
public class BinaryWatch_401 {
    public List<String> readBinaryWatch(int num) {
        List<String> times = new ArrayList<>();
        int[] hdigit = new int[]{1, 2, 4, 8};
        int[] mdigit = new int[]{1, 2, 4, 8, 16, 32};
        for(int i = 0; i <= num; i++) {
            List<Integer> hour = new ArrayList<>();
            List<Integer> minute = new ArrayList<>();
            helper(hdigit, i, 0, 0, hour);
            helper(mdigit, num - i, 0, 0, minute);
            for(int h : hour) {
                if(h >= 12) {
                    continue;
                }
                for(int m : minute) {
                    if(m >= 60) {
                        continue;
                    }
                    times.add(String.format("%d:%02d", h, m));
                }
            }
        }
        return times;
    }

    public void helper(int[] nums, int count, int pos, int sum, List<Integer> list) {
        if(count == 0) {
            list.add(sum);
            return;
        }
        for(int i = pos; i < nums.length; i++) {
            helper(nums, count - 1, i + 1, sum + nums[i], list);
        }
    }

    public static void main(String[] args) {
        BinaryWatch_401 test = new BinaryWatch_401();
        test.readBinaryWatch(0);
        int m = 0;
    }
}
