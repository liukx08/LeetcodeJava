import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by liukx08 on 5/12/2017.
 */
public class MazeExplorer {
    private static final int[][] DIRS = new int[][]{{0, -1}, {-1, 0}, {0, 1}, {1, 0}};

    public int explore(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int m = matrix.length, n = matrix[0].length;
        int counter = 0;
        Deque<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[m][n];
        visited[0][0] = true;
        queue.offer(new int[]{0, 0});
        while(!queue.isEmpty()) {
            int size = queue.size();
            counter++;
            while(size-- > 0) {
                int[] curr = queue.poll();
                for(int[] dir : DIRS) {
                    int x = curr[0] + dir[0];
                    int y = curr[1] + dir[1];
                    if(x == m - 1 && y == n - 1) {
                        return ++counter;
                    }
                    if(x >= 0 && x < m && y >= 0 && y < n && matrix[x][y] == 0 && !visited[x][y]) {
                        queue.offer(new int[]{x, y});
                        visited[x][y] = true;
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        MazeExplorer test = new MazeExplorer();
        int[][] matrix = new int[][]{{0,1,0,0,0},{0,1,0,1,0},{0,0,0,0,0},{0,1,1,1,0},{0,0,0,1,0}};
        System.out.println(test.explore(matrix));
    }
}
