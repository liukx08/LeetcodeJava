import java.util.HashMap;
import java.util.Map;

/**
 * Created by liukx08 on 4/29/2017.
 *
 *
 */
public class LongestSubstring_159 {
    // use variable
    public int lengthOfLongestSubstring(String s) {
        if(s == null) {
            return 0;
        }
        if(s.length() < 3) {
            return s.length();
        }
        char[] str = s.toCharArray();
        // track the two characters in the substring
        char first = str[0], second = str[0];
        // second len is the length of rightmost second characters substring
        int currLen = 1, secondLen = 1, maxLen = 1;
        for(int i = 1; i < str.length; i++) {
            if(str[i] != first && str[i] != second && first != second) {
                maxLen = Math.max(maxLen, currLen);
                currLen = secondLen + 1;
                secondLen = 1;
                first = second;
                second = str[i];
            } else if (str[i] != second) {
                currLen++;
                secondLen = 1;
                first = second;
                second = str[i];
            } else {
                currLen++;
                secondLen++;
            }
        }
        return Math.max(maxLen, currLen);
    }
    // use hashmap
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
