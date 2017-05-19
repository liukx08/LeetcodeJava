import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/**
 * Created by liukx08 on 5/18/2017.
 */
public class TheMazeII {
    private static final int[][] DIRS = new int[][]{{0, -1}, {-1, 0}, {0, 1}, {1, 0}};

    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        if(maze == null || maze.length == 0 || maze[0].length == 0) {
            return -1;
        }
        int m = maze.length, n = maze[0].length;
        int[][] dis = new int[m][n];
        for(int i = 0; i < m; i++) {
            Arrays.fill(dis[i], Integer.MAX_VALUE);
        }
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{start[0], start[1], 0});
        while(!queue.isEmpty()) {
            int[] pos = queue.poll();
            for(int[] dir : DIRS) {
                int x = pos[0] + dir[0], y = pos[1] + dir[1], len = pos[2] + 1;
                if(isValid(x, y, m, n, maze)) {
                    while(isValid(x, y, m, n, maze)) {
                        x += dir[0];
                        y += dir[1];
                        len++;
                    }
                    x -= dir[0];
                    y -= dir[1];
                    len--;
                    if(len >= dis[x][y]) {
                        continue;
                    }
                    dis[x][y] = len;
                    queue.offer(new int[]{x, y, len});
                }
            }
        }
        return dis[destination[0]][destination[1]] == Integer.MAX_VALUE ? -1 : dis[destination[0]][destination[1]];
    }

    private boolean isValid(int i, int j, int m, int n, int[][] maze) {
        return i >= 0 && i < m && j >= 0 && j < n && maze[i][j] == 0;
    }
}
