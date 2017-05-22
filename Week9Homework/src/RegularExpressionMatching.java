/**
 * Created by liukx08 on 5/22/2017.
 */
public class RegularExpressionMatching {
    public boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        char[] sc = s.toCharArray(), pc = p.toCharArray();
        boolean[][] match = new boolean[m + 1][n + 1];
        match[0][0] = true;
        for(int i = 2; i <= n; i++) {
            if(pc[i - 1] == '*') {
                match[0][i] = match[0][i - 2];
            }
        }
        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                if(pc[j - 1] != '*') {
                    match[i][j] = match[i - 1][j - 1] && (pc[j - 1] == '.' || sc[i - 1] == pc[j - 1]);
                } else {
                    match[i][j] = match[i][j - 2] || (pc[j - 2] == '.' || pc[j - 2] == sc[i - 1]) && match[i - 1][j];
                }
            }
        }
        return match[m][n];
    }
}
