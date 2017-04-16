import java.util.Arrays;

/**
 * Created by liukx08 on 4/15/2017.
 *          0   s   a   d
 *       0  0   1   2   3   <- base case
 *       h  1   1   2   3
 *       e  2   2   2   3
 *       a  3   3   2   3
 *       d  4   4   3   2 <- entrance
 *          ^           ^ entrance
 *          base case
 */
public class EditDistance_72 {
    // DP
    public int minDistanceDP(String word1, String word2) {
        int[][] count = new int[word1.length() + 1][word2.length() + 1];
        for(int i = 0; i < count.length; i++) {  // initialize
            count[i][0] = i;    // base case
        }
        for(int j = 0; j < count[0].length; j++) {
            count[0][j] = j;    // base case
        }
        for(int i = 1; i <= word1.length(); i++){
            for(int j = 1; j <= word2.length(); j++){
                if(word1.charAt(i - 1) == word2.charAt(j - 1)){
                    count[i][j] = count[i - 1][j - 1];
                } else {
                    count[i][j] = Math.min(Math.min(count[i - 1][j], count[i][j - 1]), count[i - 1][j - 1]) + 1;
                }
            }
        }
        return count[word1.length()][word2.length()];
    }
    // memorized search
    public int minDistance(String word1, String word2) {
        int[][] count = new int[word1.length() + 1][word2.length() + 1];
        for(int i = 0; i < count.length; i++) {  // initialize
            Arrays.fill(count[i], -1);  //
            count[i][0] = i;    // base case
        }
        for(int j = 0; j < count[0].length; j++) {
            count[0][j] = j;    // base case
        }
        return match(word1, word2, word1.length(), word2.length(), count);
    }

    private int match(String w1, String w2, int i, int j, int[][] count) {
        if(count[i][j] != -1) { // memorized search, look for result in cache
            return count[i][j];
        }
        int res;
        if(w1.charAt(i - 1) == w2.charAt(j - 1)) {          // recursion
            res = match(w1, w2, i - 1, j - 1, count);
        } else {
            int insert = match(w1, w2, i - 1, j, count);
            int replace = match(w1, w2, i - 1, j - 1, count);
            int delete = match(w1, w2, i, j - 1, count);
            res = Math.min(Math.min(insert, replace), delete) + 1;
        }
        count[i][j] = res; // store result in cache
        return res;
    }

    // recursion
/*    private int match(String w1, String w2, int i, int j) {
        if(i == w1.length()) {
            return w2.length() - j;
        }
        if(j == w2.length()) {
            return w1.length() - i;
        }
        int res;
        if(w1.charAt(i) == w2.charAt(j)) {
            res = match(w1, w2, i+1, j+1);
        } else {
            int insert = match(w1, w2, i, j + 1);
            int replace = match(w1, w2, i + 1, j + 1);
            int delete = match(w1, w2, i + 1, j);
            res = Math.min(Math.min(insert, replace), delete) + 1;
        }
        return res;
    }*/
}
