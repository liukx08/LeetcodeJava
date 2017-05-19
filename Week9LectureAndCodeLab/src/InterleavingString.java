/**
 * Created by liukx08 on 5/19/2017.
 */
public class InterleavingString {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length() + s2.length() != s3.length()) {
            return false;
        }
        return dfsHelper(s1.toCharArray(), s2.toCharArray(), s3.toCharArray(), 0, 0, 0, new int[s1.length() + 1][s2.length() + 1]);
    }

    public boolean dfsHelper(char[] s1, char[] s2, char[] s3, int i, int j, int k, int[][] valid) {
        if(k == s3.length || valid[i][j] == 1) {
            return true;
        }
        if(valid[i][j] == -1) {
            return false;
        }
        boolean res = i < s1.length && s1[i] == s3[k] && dfsHelper(s1, s2, s3, i + 1, j, k + 1, valid) ||
                j < s2.length && s2[j] == s3[k] && dfsHelper(s1, s2, s3, i, j + 1, k + 1, valid);
        valid[i][j] = res ? 1 : -1;
        return res;
    }
}
