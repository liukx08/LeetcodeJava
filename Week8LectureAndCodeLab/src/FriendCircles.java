/**
 * Created by liukx08 on 5/13/2017.
 */
public class FriendCircles {
    public int findCircleNum(int[][] M) {
        if(M == null || M.length == 0 || M[0].length == 0) {
            return 0;
        }
        int n = M.length;
        int[] id = new int[n];
        for(int i = 0; i < n; i++) {
            id[i] = i;
        }
        int count = n;
        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                if(M[i][j] == 1) {
                    int iRoot = find(id, i);
                    int jRoot = find(id, j);
                    if(iRoot != jRoot) {
                        id[jRoot] = iRoot;
                        count--;
                    }
                }
            }
        }
        return count;
    }

    private int find(int[] id, int p) {
        while(p != id[p]) {
            id[p] = id[id[p]];
            p = id[p];
        }
        return p;
    }
}
