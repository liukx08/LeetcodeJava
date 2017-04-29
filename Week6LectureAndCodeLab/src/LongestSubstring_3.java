/**
 * Created by liukx08 on 4/29/2017.
 */
public class LongestSubstring_3 {
    public int lengthOfLongestSubstring(String s) {
        if(s == null) {
            return 0;
        }
        if(s.length() < 2) {
            return s.length();
        }
        // Array map tracking the index of last character before end
        int[] map = new int[128];
        char[] str = s.toCharArray();
        int max = 0;
        int start = 0;
        for(int end = 0; end < str.length; end++) {
            // not shown yet
            if(map[str[end]] == 0) {
                max = Math.max(max, end - start + 1);
            } else {
                // shown before, if on the right of start, move start to the new index
                start = Math.max(start, map[str[end]]);
                max = Math.max(max, end - start + 1);
            }
            // update index
            map[str[end]] = end + 1;
        }
        return max;
    }

    public static void main(String[] args) {
        LongestSubstring_3 test = new LongestSubstring_3();
        test.lengthOfLongestSubstring("au");
    }
}
