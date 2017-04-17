import java.util.HashMap;

/**
 * Created by liukx08 on 4/17/2017.
 */
public class WordPatternII_291 {
    public boolean wordPatternMatch(String pattern, String str) {
        return helper(pattern, str, 0, 0, new HashMap<Character, String>());
    }

    private boolean helper(String pattern, String str, int i, int j, HashMap<Character, String> map) {
        if(i == pattern.length() && j == str.length()) {
            return true;    // base case
        }
        if(i == pattern.length()) {
            return false;   // base case
        }
        // if pattern.charAt(i) has been assigned a string
        if(map.containsKey(pattern.charAt(i))) {
            String curr = map.get(pattern.charAt(i));
            if(j + curr.length() > str.length() || !curr.equals(str.substring(j, j + curr.length()))) {
                return false;   // doesn't match, return
            }
            return helper(pattern, str, i + 1, j + curr.length(), map); // match, go deeper
        }
        // try to assign different string to pattern.charAt(i)
        for(int l = j + 1; l <= str.length(); l++) {
            if(map.containsValue(str.substring(j, l))) {
                continue;   // skip duplicate pattern
            }
            map.put(pattern.charAt(i), str.substring(j, l));    // add pattern
            if(helper(pattern, str, i + 1, l, map)) {
                return true;    // go deeper
            }
            map.remove(pattern.charAt(i));  // backtracking
        }
        return false;
    }

    public static void main(String[] args) {
        WordPatternII_291 test = new WordPatternII_291();
        boolean tmp = test.wordPatternMatch("abba","catdogdogcat");
        System.out.println(tmp);
    }
}
