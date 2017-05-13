import java.util.ArrayList;
import java.util.List;

/**
 * Created by liukx08 on 5/13/2017.
 */
public class NumberOfIslandsII_305 {

    private static final int[][] DIRS = new int[][]{{0, -1}, {-1, 0}, {0, 1}, {1, 0}};

    class UnionFind {
        private int[] id;
        private int[] size;
        private int[][] sea;
        private int m;
        private int n;
        private int count;

        public UnionFind(int m, int n) {
            this.m = m;
            this.n = n;
            id = new int[m * n];
            size = new int[m * n];
            sea = new int[m][n];
            count = 0;
        }

        public int getCount() {
            return count;
        }

        public void add(int i, int j) {
            int curr = i * n + j;
            sea[i][j] = 1;
            id[curr] = curr;
            size[curr] = 1;
            count++;
            for(int[] dir : DIRS) {
                int x = i + dir[0];
                int y = j + dir[1];
                int next = x * n + y;
                if(x >= 0 && x < m && y >= 0 && y < n && sea[x][y] == 1) {
                    union(curr, next);
                }
            }
        }

        public int find(int p) {
            while(p != id[p]) {
                id[p] = id[id[p]];
                p = id[p];
            }
            return p;
        }

        public boolean isConnected(int p, int q) {
            return find(p) == find(q);
        }

        public void union(int p, int q) {
            int pRoot = find(p);
            int qRoot = find(q);
            if(pRoot == qRoot) {
                return;
            }
            if(size[pRoot] > size[qRoot]) {
                id[qRoot] = pRoot;
                size[pRoot] += size[qRoot];
            } else {
                id[pRoot] = qRoot;
                size[qRoot] += size[pRoot];
            }
            count--;
        }
    }

    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> res = new ArrayList<>();
        if(positions == null || positions.length == 0 || positions[0].length == 0) {
            return res;
        }
        UnionFind sol = new UnionFind(m, n);
        for(int[] land : positions) {
            sol.add(land[0], land[1]);
            res.add(sol.getCount());
        }
        return res;
    }
}
