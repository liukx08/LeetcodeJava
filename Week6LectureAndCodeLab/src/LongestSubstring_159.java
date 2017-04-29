import java.util.HashMap;
import java.util.Map;

/**
 * Created by liukx08 on 4/29/2017.
 *
 *
 */
public class LongestSubstring_159 {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if(s == null) {
            return 0;
        }
        if(s.length() < 3) {
            return s.length();
        }
        // use hash map to track index
        Map<Character, Integer> map = new HashMap<>();
        char[] str = s.toCharArray();
        int start = 0, end = 0;
        int max = 0;
        while(end < str.length) {
            if(map.size() < 2 || (map.size() == 2 && map.containsKey(str[end]))) {
                map.put(str[end], end + 1);
            } else {
                max = Math.max(max, end - start);
                start = end;
                for(int idx : map.values()) {
                    start = Math.min(start, idx);
                }
                map.remove(str[start - 1]);
                map.put(str[end], end + 1);
            }
            end++;
        }
        return Math.max(max, end - start);
    }
}
