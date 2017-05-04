import java.util.NavigableMap;
import java.util.TreeMap;

/**
 * Created by liukx08 on 5/3/2017.
 */
public class FindRightInterval {
    public class Interval {
        int start;
        int end;
        Interval() {
            start = 0;
            end = 0;
        }
        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }

    public int[] findRightInterval(Interval[] intervals) {
        if(intervals == null || intervals.length == 0) {
            return new int[0];
        }
        NavigableMap<Integer, Integer> map = new TreeMap<>();
        for(int i = 0; i < intervals.length; i++) {
            map.put(intervals[i].start, i);
        }
        int[] res = new int[intervals.length];
        for(int i = 0; i < intervals.length; i++) {
            Integer key = map.ceilingKey(intervals[i].end);
            res[i] = key == null ? -1 : map.get(key);
        }
        return res;
    }

    public static void main(String[] args) {
        FindRightInterval test = new FindRightInterval();
        Interval[] input = new Interval[]{test.new Interval(1, 2), test.new Interval(3,4)};
        int[] res = test.findRightInterval(input);
        System.out.println(String.format("%d %d", res[0], res[1]));
    }
}
