import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by liukx08 on 4/22/2017.
 */
public class MergeIntervals_56 {
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
    // When there is a start, there must be an end
    public List<Interval> mergefast(List<Interval> intervals) {
        List<Interval> res = new ArrayList<>();
        if(intervals.size() == 0) {
            return res;
        }
        int n = intervals.size();
        // use two arrays to store start time and end time
        int[] start = new int[n];
        int[] end = new int[n];
        for(int i = 0; i < n; i++) {
            start[i] = intervals.get(i).start;
            end[i] = intervals.get(i).end;
        }
        // sort start time and end time
        Arrays.sort(start);
        Arrays.sort(end);
        // rule: there is a start, there must be an end
        for(int i = 0, j = 0; i < n; i++) {
            // check if this end time is before next start time
            if(i == n - 1 || end[i] < start[i + 1]) {
                res.add(new Interval(start[j], end[i]));
                j = i + 1;
            }
        }
        return res;
    }

    // too slow, why ? collection sort?
    public List<Interval> merge(List<Interval> intervals) {
        Collections.sort(intervals, (a, b) -> a.start - b.start);
        List<Interval> res = new ArrayList<>();
        if(intervals.size() == 0) {
            return res;
        }
        int s = intervals.get(0).start;
        int e = intervals.get(0).end;
        for(int i = 1; i < intervals.size(); i++) {
            if(intervals.get(i).start <= e) {
                e = Math.max(e, intervals.get(i).end);
            } else {
                res.add(new Interval(s, e));
                s = intervals.get(i).start;
                e = intervals.get(i).end;
            }
        }
        res.add(new Interval(s, e));
        return res;
    }
}
