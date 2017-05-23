import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by liukx08 on 5/22/2017.
 */
public class FrogJump {
    // DFS
    public boolean canCrossDFS(int[] stones) {
        if(stones == null || stones.length < 2) {
            return true;
        }
        if(stones[1] != 1) {
            return false;
        }
        int n = stones.length;
        Set<Integer> stone = new HashSet<>();
        for(int i = 0; i < n; i++) {
            if (i > 3 && stones[i] > stones[i - 1] * 2) {
                return false;
            }
            stone.add(stones[i]);
        }
        return canReach(stone, 1, 1, stones[n - 1]);
    }

    private boolean canReach(Set<Integer> stone, int start, int step, int des) {
        int tmp = start + step;
        if(tmp - 1 == des || tmp == des || tmp + 1 == des ) {
            return true;
        }
        if(stone.contains(tmp + 1) && canReach(stone, tmp + 1, step + 1, des)) {
            return true;
        }
        if(stone.contains(tmp) && canReach(stone, tmp, step, des)) {
            return true;
        }
        if(step > 1 && stone.contains(tmp - 1) && canReach(stone, tmp - 1, step - 1, des)) {
            return true;
        }
        return false;
    }
    // DP
    public boolean canCross(int[] stones) {
        if(stones == null || stones.length < 2) {
            return true;
        }
        Map<Integer, Set<Integer>> steps = new HashMap<>();
        steps.put(0, new HashSet<>());
        steps.get(0).add(1);
        for(int i = 1; i < stones.length; i++) {
            steps.put(stones[i], new HashSet<>());
        }
        for(int i = 0; i < stones.length - 1; i++) {
            int stone = stones[i];
            for(int step : steps.get(stone)) {
                int reach = stone + step;
                if(reach == stones[stones.length - 1]) {
                    return true;
                }
                Set<Integer> set = steps.get(reach);
                if(set != null) {
                    set.add(step);
                    if(step > 1) {
                        set.add(step - 1);
                    }
                    set.add(step + 1);
                }
            }
        }
        return false;
    }
}
