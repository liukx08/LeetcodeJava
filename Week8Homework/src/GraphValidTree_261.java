/**
 * Created by liukx08 on 5/14/2017.
 */
public class GraphValidTree_261 {
    // union find
    public boolean validTree(int n, int[][] edges) {
        if(n == 0) {
            return true;
        }
        int[] id = new int[n];
        for(int i = 0; i < n; i++) {
            id[i] = i;
        }
        for(int[] edge : edges) {
            int root1 = find(id, edge[0]);
            int root2 = find(id, edge[1]);
            if(root1 == root2) {
                return false;
            }
            id[root2] = root1;
        }
        return edges.length == n - 1;
    }

    private int find(int[] id, int p) {
        while(p != id[p]) {
            id[p] = id[id[p]];
            p = id[p];
        }
        return p;
    }

    // BFS
//    public boolean validTree(int n, int[][] edges) {
//        if(n == 0) {
//            return true;
//        }
//        List<Integer>[] neighbors = new List[n];
//        for(int i = 0; i < n; i++) {
//            neighbors[i] = new ArrayList<>();
//        }
//        for(int[] edge : edges) {
//            neighbors[edge[0]].add(edge[1]);
//            neighbors[edge[1]].add(edge[0]);
//        }
//        boolean[] visited = new boolean[n];
//        Queue<Integer> queue = new ArrayDeque<>();
//        queue.offer(0);
//        while(!queue.isEmpty()) {
//            int curr = queue.poll();
//            if(visited[curr]) {
//                return false;
//            }
//            visited[curr] = true;
//            for(int nei : neighbors[curr]) {
//                if(visited[nei]) {
//                    continue;
//                }
//                queue.offer(nei);
//            }
//        }
//        for(int i = 0; i < n; i++) {
//            if(!visited[i]) {
//                return false;
//            }
//        }
//        return true;
//    }

    // DFS
//    public boolean validTree(int n, int[][] edges) {
//        if(n == 0) {
//            return true;
//        }
//        List<Integer>[] neighbors = new List[n];
//        for(int[] edge : edges) {
//            if(neighbors[edge[0]] == null) {
//                neighbors[edge[0]] = new ArrayList<>();
//            }
//            neighbors[edge[0]].add(edge[1]);
//            if(neighbors[edge[1]] == null) {
//                neighbors[edge[1]] = new ArrayList<>();
//            }
//            neighbors[edge[1]].add(edge[0]);
//        }
//        boolean[] visited = new boolean[n];
//        if(findCircle(0, -1, neighbors, visited)) {
//            return false;
//        }
//        for(int i = 0; i < n; i++) {
//            if(!visited[i]) {
//                return false;
//            }
//        }
//        return true;
//    }
//
//    private boolean findCircle(int node, int prev, List<Integer>[] nei, boolean[] visited) {
//        if(visited[node] == true) {
//            return true;
//        }
//        visited[node] = true;
//        if(nei[node] != null) {
//            for(int next : nei[node]) {
//                if(next == prev) {
//                    continue;
//                }
//                if(findCircle(next, node, nei, visited)) {
//                    return true;
//                }
//            }
//        }
//        return false;
//    }
}
