/**
 * Created by liukx08 on 5/21/2017.
 */
public class PalindromePartitioningII {
    public int minCut(String s) {
        if (s == null || s.length() < 2) {
            return 0;
        }
        char[] c = s.toCharArray();
        int n = c.length;
        int[] cut = new int[n];
        boolean[][] palindrome = new boolean[n][n];
        for(int i = 0; i < c.length; i++) {
            int min = i;
            for(int j = 0; j <= i; j++) {
                if(c[i] == c[j] && (i - 1 < j + 1 || palindrome[i - 1][j + 1])) {
                    palindrome[i][j] = true;
                    min = j == 0 ? 0 : Math.min(min, cut[j - 1] + 1);
                }
                cut[i] = min;
            }
        }
        return cut[n - 1];
    }
}
