import java.util.HashMap;
import java.util.Map;

/**
 * Created by liukx08 on 4/30/2017.
 */
public class LongestSubstringK_340 {
    // use array map
    public int lengthOfLongestK(String s, int k) {
        if(s == null || k == 0) {
            return 0;
        }
        if(s.length() <= k) {
            return s.length();
        }
        // count the character quantity in current substring
        int[] count = new int[128];
        char[] str = s.toCharArray();
        int start = 0, maxLen = 0;
        for(int end = 0; end < str.length; end++) {
            // move right pointer a character further
            if(count[str[end]]++ == 0) {
                k--;
            }
            // check the validity of current substring
            if(k < 0) {
                while(--count[str[start++]] > 0);
                k++;
            }
            // update maximum length
            maxLen = Math.max(maxLen, end - start + 1);
        }
        return maxLen;
    }
    // the same as 159
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if(s == null || k == 0) {
            return 0;
        }
        if(s.length() <= k) {
            return s.length();
        }
        Map<Character, Integer> index = new HashMap<>();
        char[] str = s.toCharArray();
        int start = 0, end = 0, maxLen = 0;
        while(end < str.length) {
            if(index.size() < k || index.containsKey(str[end])) {
                index.put(str[end], end + 1);
            } else {
                maxLen = Math.max(maxLen, end - start);
                start = end;
                for(int idx : index.values()) {
                    start = Math.min(start, idx);
                }
                index.remove(str[start - 1]);
                index.put(str[end], end + 1);
            }
            end++;
        }
        return Math.max(maxLen, end - start);
    }
}
