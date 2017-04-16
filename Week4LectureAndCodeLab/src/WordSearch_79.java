/**
 * Created by liukx08 on 4/16/2017.
 */
public class WordSearch_79 {
    public boolean exist(char[][] board, String word) {
        if(word == null || word.length() == 0) {
            return true;
        }
        if(board == null || board.length == 0 || board[0].length == 0) {
            return false;
        }
        char[] str = word.toCharArray();
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(exist(board, str, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private int[][] DIRS = new int[][]{{0, -1}, {-1, 0}, {0, 1}, {1, 0}};

    private boolean exist(char[][] board, char[] w, int i, int j, int start) {
        if(start == w.length) {
            return true;
        }
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || w[start] != board[i][j]) {
            return false;
        }
        board[i][j] ^= 256;     // mark as not letter
        boolean res = false;
        for(int[] dir: DIRS) {
            int x = i + dir[0];
            int y = j + dir[1];
            res = res || exist(board, w, x, y, start + 1);
        }
        board[i][j] ^= 256;     // recover
        return res;
    }
}
