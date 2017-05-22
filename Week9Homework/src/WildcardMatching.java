/**
 * Created by liukx08 on 5/22/2017.
 */
public class WildcardMatching {
    public boolean isMatch(String s, String p) {
        if(p.isEmpty() && !s.isEmpty()) {
            return false;
        }
        char[] arrays = s.toCharArray(), arrayp = p.toCharArray();
        int m = arrays.length, n = arrayp.length;
        boolean[] match = new boolean[n + 1];
        match[0] = true;
        for(int i = 1; i <= n; i++) {
            if(arrayp[i - 1] == '*') {
                match[i] = match[i - 1];
            }
        }
        boolean leftUpper = true;
        for(int i = 0; i < m; i++) {
            for(int j = 1; j <= n; j++) {
                if(arrayp[j - 1] != '*') {
                    boolean temp = match[j];
                    match[j] = (arrayp[j - 1] == '?' || arrayp[j - 1] == arrays[i]) && leftUpper;
                    leftUpper = temp;
                } else {
                    leftUpper = match[j];
                    match[j] = match[j] || match[j - 1];
                }
            }
            leftUpper = false;
        }
        return match[n];
    }
}
