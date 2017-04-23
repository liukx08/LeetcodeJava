import java.util.ArrayList;
import java.util.List;

/**
 * Created by liukx08 on 4/23/2017.
 */
public class InsertInterval_57 {
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


    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> res = new ArrayList<>();
        int i = 0;
        // start > end, no overlap
        while(i < intervals.size() && newInterval.start > intervals.get(i).end) {
            res.add(intervals.get(i++));
        }
        // starting to overlap, end >= start, still overlap, merge one by one
        while(i < intervals.size() && newInterval.end >= intervals.get(i).start) {
            newInterval = new Interval(Math.min(newInterval.start, intervals.get(i).start), Math.max(newInterval.end, intervals.get(i).end));
            i++;
        }
        res.add(newInterval);
        // add remained interval
        while(i < intervals.size()) {
            res.add(intervals.get(i++));
        }
        return res;
    }
}
