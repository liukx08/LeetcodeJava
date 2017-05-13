/**
 * Created by liukx08 on 5/13/2017.
 */
public class UnionFind {

    private int[] id;
    private int count;
    // weighted quick union
    private int[] size;

    // initialization
    public UnionFind(int n) {
        if(n <= 0) {
            return;
        }
        id = new int[n];
        // weighted quick union
        size = new int[n];
        count = n;
        for(int i = 0; i < n; i++) {
            id[i] = i;
            size[i] = 1;
        }
    }

    // count no. of groups
    public int getCount() {
        return count;
    }

    // judge whether p and q are connected
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    // find group on. of p, O(1)
    public int find(int p) {
        return id[p];

        // Quick union optimization, O(h) find
//        while(p != id[p]) {
        // weighted quick union with path compression
        //id[p] = id[id[p]];
//            p = id[p];
//        }
//        return p;
    }

    // union p and q into the same group, O(n)
    public void union(int p, int q) {
        if(isConnected(p, q)) {
            return;
        }
        int pID = find(p), qID = find(q);
        for(int i = 0; i < id.length; i++) {
            if(id[i] == qID) {
                id[i] = pID;
            }
        }
        count--;

        // Quick union optimization O(h)
//        int pRoot = find(p), qRoot = find(q);
//        if(pRoot == qRoot) {
//            return;
//        }
//        id[qRoot] = pRoot;
//        count--;

        // weighted quick union
//        int pRoot = find(p), qRoot = find(q);
//        if(pRoot == qRoot) {
//            return;
//        }
//        if(size[pRoot] > size[qRoot]) {
//            id[qRoot] = pRoot;
//            size[pRoot] += size[qRoot];
//        } else {
//            id[pRoot] = qRoot;
//            size[qRoot] += size[pRoot];
//        }
//        count--;
    }
}
