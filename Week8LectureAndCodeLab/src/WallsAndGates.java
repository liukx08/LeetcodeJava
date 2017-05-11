import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by liukx08 on 5/11/2017.
 */
public class WallsAndGates {
    private static final int[][] DIRS = new int[][]{{0, -1}, {-1, 0}, {0, 1}, {1, 0}};

    public void wallsAndGates(int[][] rooms) {
        if(rooms == null || rooms.length == 0 || rooms[0].length == 0) {
            return;
        }
        int m = rooms.length, n = rooms[0].length;
        Deque<int[]> queue = new ArrayDeque<>();
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(rooms[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                }
            }
        }
        dfsHelper(queue, rooms, m, n);
    }

    private void dfsHelper(Deque<int[]> queue, int[][] rooms, int m, int n) {
        int x, y;
        while(!queue.isEmpty()) {
            int[] curr = queue.poll();
            for(int[] dir : DIRS) {
                x = curr[0] + dir[0];
                y = curr[1] + dir[1];
                if(x >= 0 && x < m && y >= 0 && y < n && rooms[x][y] == Integer.MAX_VALUE) {
                    rooms[x][y] = rooms[curr[0]][curr[1]] + 1;
                    queue.offer(new int[]{x, y});
                }
            }
        }
    }
}
