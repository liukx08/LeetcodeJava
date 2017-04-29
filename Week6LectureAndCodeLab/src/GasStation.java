/**
 * Created by liukx08 on 4/29/2017.
 */
public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int fuel = gas[0] - cost[0], start = 0, end = 0;
        for(int i = 0; i < gas.length; i++) {
            // enough fuel, go to next station
            if(fuel >= 0) {
                end = (end + 1) % gas.length;
                fuel += gas[end] - cost[end];
                // no enough fuel, start from prior station
            } else {
                start = (start - 1 + gas.length) % gas.length;
                fuel += gas[start] - cost[start];
            }
        }
        if(fuel >= 0) {
            return start;
        }
        return -1;
    }
}
