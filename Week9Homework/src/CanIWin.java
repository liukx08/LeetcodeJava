/**
 * Created by liukx08 on 5/22/2017.
 */
public class CanIWin {
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        int sum = (1 + maxChoosableInteger) * maxChoosableInteger / 2;
        if (sum < desiredTotal) {
            return false;
        }
        if (desiredTotal <= 0) {
            return true;
        }
        return helper(maxChoosableInteger, desiredTotal, new HashMap<Integer, Boolean>(), new int[]{0});
    }

    private boolean helper(int max, int desire, Map<Integer,Boolean> map, int[] used) {
        if(desire <= 0) {
            return false;
        }
        if(map.containsKey(used[0])) {
            return map.get(used[0]);
        }
        for(int i = 1; i <= max; i++) {
            if(((used[0] >> i) & 1) == 1) {
                continue;
            }
            used[0] ^= (1 << i);
            if(!helper(max, desire - i, map, used)) {
                used[0] ^= (1 << i);
                map.put(used[0], true);
                return true;
            }
            used[0] ^= (1 << i);
        }
        map.put(used[0], false);
        return false;
    }
}
