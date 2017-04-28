/**
 * Created by liukx08 on 4/27/2017.
 */
public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        if(s == null || t == null || s.length() == 0 || t.length() == 0 || t.length() > s.length()) {
            return new String();
        }
        int count = 0;
        // ArrayMap count characters in t
        int[] map = new int[128];
        for(char c : t.toCharArray()) {
            map[c]++;
            count++;
        }
        char[] str = s.toCharArray();
        // use lenMin to track the shortest substring length, startIdx is the starting index
        int lenMin = Integer.MAX_VALUE, startIdx = 0;
        // two pointers start and end to mark the substring
        for(int start = 0, end = 0; end < str.length; end++) {
            // move end pointer to find a matched substring
            if(map[str[end]] > 0) { // find a match
                count--;
            }
            map[str[end]]--;
            // found matched substring, move start pointer
            while(count == 0) {
                if(map[str[start]] == 0) {
                    count++;
                    if(end - start + 1 < lenMin) {
                        lenMin = end - start + 1;
                        startIdx = start;
                    }
                }
                map[str[start]]++;
                start++;
            }
        }
        return lenMin == Integer.MAX_VALUE ? new String():new String(str, startIdx, lenMin);
    }
}
