/**
 * Created by liukx08 on 4/17/2017.
 *             t
 *             v s->  r a b b b i t
 *             r      1 1 1 1 1 1 1
 *             a      0
 *             b      0 0
 *             i      0 0 0
 *             t      0 0 0 0
 *              if (t(i) = s(i)) => t(0,i) in s(0,i-1) or t(0,i-1) in s(0,i-1)
 *              else => only t(0,i) in s(0,i-1)
 */
public class DistinctSubsequences_115 {
    public int numDistinct(String s, String t) {
        if(t.length() > s.length()) {
            return 0;   // invalid
        }
        int[][] count = new int[t.length()][s.length()];
        count[0][0] = s.charAt(0) == t.charAt(0) ? 1 : 0;
        for(int i = 1; i < s.length(); i++) {
            count[0][i] = s.charAt(i) == t.charAt(0) ? (count[0][i - 1] + 1) : count[0][i - 1];
        }
        for(int i = 1; i < t.length(); i++) {
            for(int j = i; j < s.length(); j++) {
                if(s.charAt(j) == t.charAt(i)) {
                    count[i][j] = count[i][j - 1] + count[i - 1][j - 1];
                } else {
                    count[i][j] = count[i][j - 1];
                }
            }
        }
        return count[t.length() - 1][s.length() - 1];
    }
}
