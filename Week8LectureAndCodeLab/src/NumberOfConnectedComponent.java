/**
 * Created by liukx08 on 5/13/2017.
 */
public class NumberOfConnectedComponent {
    public int countComponents(int n, int[][] edges) {
        if(n <= 1) {
            return n;
        }
        int[] id = new int[n];
        for(int i = 0; i < n; i++) {
            id[i] = i;
        }
        for(int[] edge : edges) {
            int pID = find(id, edge[0]);
            int qID = find(id, edge[1]);
            id[qID] = pID;
        }
        int count = 0;
        for(int i = 0; i < n; i++) {
            if(id[i] == i) {
                count++;
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
