/**
 * Created by liukx08 on 4/22/2017.
 */
public class HitCounter {

    int[] times;

    int[] hits;

    int timeOfLastHit;

    /** Initialize your data structure here. */
    public HitCounter() {
        // use a fixed size array to record timestamp
        times = new int[300];
        // usa another array to record hits at a timestamp
        hits = new int[300];
        // use an integer to track the most recent hit
        timeOfLastHit = 0;
    }

    /** Record a hit.
     @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        int idx = timestamp % 300;
        // timestamp matches the stored timestamp, count hit
        if(times[idx] == timestamp) {
            hits[idx]++;
        } else {    // if timestamp expires, update hit
            hits[idx] = 1;
        }
        // track last hit
        timeOfLastHit = timestamp;
    }

    /** Return the number of hits in the past 5 minutes.
     @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        int total = 0;
        // count hits from 300 s ago to last hit
        for(int i = Math.max(timestamp - 300, 0) + 1; i <= timeOfLastHit; i++) {
            if(times[i % 300] > timestamp - 300) {
                total += hits[i % 300];
            }
        }
        return total;
    }
}
