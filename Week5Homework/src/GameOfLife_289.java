/**
 * Created by liukx08 on 4/23/2017.
 */
public class GameOfLife_289 {
    // use the second digit to record new state
    public void gameOfLife(int[][] board) {
        if(board == null || board.length == 0 || board[0].length == 0) {
            return;
        }
        int m = board.length;
        int n = board[0].length;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                // count live cells around
                int lives = 0;
                for(int x = Math.max(i - 1, 0); x <= Math.min(i + 1, m - 1); x++) {
                    for(int y = Math.max(j - 1, 0); y <= Math.min(j + 1, n - 1); y++) {
                        lives += board[x][y] & 1; // only count the last digit
                    }
                }
                lives -= board[i][j]; // minus (i,j) which is added above, (i,j) is not updated yet
                if(lives == 3 || (lives == 2 && board[i][j] == 1)) {
                    board[i][j] += 2;   // record state using the second digit
                }
            }
        }
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                // update state
                board[i][j] = board[i][j] >> 1;
            }
        }
    }
}
