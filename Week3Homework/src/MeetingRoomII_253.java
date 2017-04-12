import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Created by liukx08 on 4/11/2017.
 */
public class MeetingRoomII_253 {
    public class Interval{
        int start;
        int end;
        Interval(){start=0;end=0;}
        Interval(int s,int e){
            start=s;
            end=e;
        }
    }
    // event count
    public int minRoom(Interval[] intervals) {
        if(intervals==null||intervals.length==0)return 0;
        int min=0;
        int[] start=new int[intervals.length];
        int[] end=new int[intervals.length];
        for(int i=0;i<intervals.length;i++){
            start[i]=intervals[i].start;
            end[i]=intervals[i].end;
        }
        Arrays.sort(start);
        Arrays.sort(end);
        int e=0;
        for(int i=0;i<start.length;i++){
            if(start[i]<end[e])min++;
            else e++;
        }
        return min;
    }

    // use min heap
    public int minMeetingRooms(Interval[] intervals) {
        if(intervals==null||intervals.length==0)return 0;
        int min=0;
        Arrays.sort(intervals,(a, b)->a.start-b.start);
        PriorityQueue<Integer> queue=new PriorityQueue<>();
        for(int i=0;i<intervals.length;i++){
            while(queue.size()!=0&&queue.peek()<=intervals[i].start)queue.poll();
            queue.offer(intervals[i].end);
            min=Math.max(min,queue.size());
        }
        return min;
    }
}
