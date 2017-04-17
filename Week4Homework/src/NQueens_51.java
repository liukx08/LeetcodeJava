import java.util.*;

/**
 * Created by liukx08 on 4/17/2017.
 *   n queens on (n X n) board :
 *      1. each row has exactly one queen
 *      2. each column has exactly one queen
 *         => con1: int[n] can be used to store the column number (0 ~ n-1) of the queen at row i (0 ~ n-1)
 *      3. no two queens on the same diagonal line
 *         => con2: (i + j) != (i' + j') && (i - j) != (i' - j')
 */
public class NQueens_51 {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        helper(n, res, new int[n], 0, new boolean[n], new HashSet<Integer>(), new HashSet<Integer>());
        return res;
    }
    // backtracking: coord -> con1, k -> k th queen at row k, occupy -> if column j is occupy, plus and minus store diagonal lines -> con2
    private void helper(int n, List<List<String>> res, int[] coord, int k, boolean[] occupy, Set<Integer> plus, Set<Integer> minus) {
        if(k == n) {    // all coordinates are determined, found a solution
            List<String> ans = new ArrayList<String>();
            for(int i = 0; i < n; i++) {
                char[] row = new char[n];
                Arrays.fill(row, '.');
                row[coord[i]] = 'Q';
                ans.add(new String(row));
            }
            res.add(ans);
            return;
        }
        // recursion
        for(int i = 0; i < n; i++) {
            if(occupy[i] || plus.contains(k + i) || minus.contains(k - i)) {
                continue;   // column i or diagonal line is occupied
            }
            occupy[i] = true;
            coord[k] = i;       // add coordinate of k th queen
            plus.add(k + i);
            minus.add(k - i);
            helper(n, res, coord, k + 1, occupy, plus, minus);  // go deeper
            occupy[i] = false;  // back tracking
            plus.remove(k + i);
            minus.remove(k - i);
        }
    }
}
