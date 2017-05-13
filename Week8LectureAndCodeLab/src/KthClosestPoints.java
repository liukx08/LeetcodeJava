import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by liukx08 on 5/12/2017.
 */
public class KthClosestPoints {
    public int[] closest(int[] a, int[] b, int[] c, int k) {
        if(a == null || b == null || c == null || a.length * b.length * c.length < k) {
            return new int[0];
        }
        int[][] dirs = new int[][]{{1, 0, 0}, {0, 1, 0}, {0, 0, 1}};
        int lena = a.length, lenb = b.length, lenc = c.length;
        int[] res = new int[3];
        boolean[][][] visited = new boolean[lena][lenb][lenc];
        Queue<int[]> minHeap = new PriorityQueue<>((p1, p2) -> a[p1[0]] * a[p1[0]] +
                b[p1[1]] * b[p1[1]] + c[p1[2]] * c[p1[2]] - (a[p2[0]] * a[p2[0]] +
                b[p2[1]] * b[p2[1]] + c[p2[2]] * c[p2[2]]));
        minHeap.offer(new int[]{0,0,0});
        visited[0][0][0] = true;
        while(k-- > 0) {
            int[] idx = minHeap.poll();
            res[0] = a[idx[0]];
            res[1] = b[idx[1]];
            res[2] = c[idx[2]];
            for(int[] dir : dirs) {
                int x = idx[0] + dir[0], y = idx[1] + dir[1], z = idx[2] + dir[2];
                if(x < lena && y < lenb && z < lenc && !visited[x][y][z]) {
                    minHeap.offer(new int[]{x, y, z});
                    visited[x][y][z] = true;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        KthClosestPoints test = new KthClosestPoints();
        int[] res = test.closest(new int[]{1, 3, 5}, new int[]{0, 3}, new int[]{1, 2}, 5);
        System.out.println(String.format("%d, %d, %d",res[0],res[1],res[2]));
    }
}
