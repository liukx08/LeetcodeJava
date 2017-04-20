import java.util.HashMap;
import java.util.Map;

/**
 * Created by liukx08 on 4/20/2017.
 *
 *          memorized search: state: some of 1 ~ n are chosen, at this time, can I win?
 *          since n <= 20, we can use an integer instead of a boolean array to indicate an intermediate state
 *
 */
public class CanIWin_464 {
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
            return false;   // base case, desire total becomes 0 or negative, I lose
        }
        if(map.containsKey(used[0])) {
            return map.get(used[0]);    // memorized search, look up result in cache
        }
        for(int i = 1; i <= max; i++) {
            if(((used[0] >> i) & 1) == 1) continue; // i is not chosen
            // warning: add/recursion/remove lines has to follow one by one without any other line among them
            used[0] ^= (1 << i);    // set i th bit to 1
            if(!helper(max, desire - i, map, used)) { // if my opponent can't win
                used[0] ^= (1 << i);    // set i th bit back to 0
                map.put(used[0], true); // I win
                return true;
            }
            used[0] ^= (1 << i);
        }  // tried all choices, I can't win in any case, then I loose
        map.put(used[0], false);
        return false;
    }

    public static void main(String[] args) {
        CanIWin_464 test = new CanIWin_464();
        boolean res = test.canIWin(10, 40);
        System.out.println(res);
    }
}
