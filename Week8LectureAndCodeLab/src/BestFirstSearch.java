import java.util.*;

/**
 * Created by liukx08 on 5/12/2017.
 */
public class BestFirstSearch {
    public List<Integer> dijkstra(Map<Integer, List<int[]>> graph, int start, int end) {
        List<Integer> res = new LinkedList<>();
        if(!graph.containsKey(start) || !graph.containsKey(end)) {
            return res;
        }
        boolean[] visited = new boolean[graph.size()];
        int[] dist = new int[graph.size()];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        int[] prev = new int[graph.size()];
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> dist[a] - dist[b]);
        minHeap.offer(start);
        while(!minHeap.isEmpty()) {
            int curr = minHeap.poll();
            if(curr == end) {
                break;
            }
            visited[curr] = true;
            if(graph.containsKey(curr)) {
                for (int nei[] : graph.get(curr)) {
                    if (dist[nei[0]] == Integer.MAX_VALUE) {
                        minHeap.offer(nei[0]);
                    }
                    if (!visited[nei[0]]) {
                        int newDis = dist[curr] + nei[1];
                        if (newDis < dist[nei[0]]) {
                            dist[nei[0]] = newDis;
                            prev[nei[0]] = curr;
                        }
                    }
                }
            }
        }
        if(dist[end] == Integer.MAX_VALUE) {
            return res;
        }
        res.add(dist[end]);
        int i = end;
        while(i != start) {
            res.add(0, i);
            i = prev[i];
        }
        res.add(0, start);
        return res;
    }

    public static void main(String[] args) {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for(int i = 0; i < 7; i++) {
            graph.put(i, new ArrayList<int[]>());
        }
        graph.get(0).add(new int[]{1,1});
        graph.get(0).add(new int[]{2,3});
        graph.get(0).add(new int[]{3,2});
        graph.get(2).add(new int[]{0,3});
        graph.get(2).add(new int[]{6,4});
        graph.get(1).add(new int[]{0,1});
        graph.get(1).add(new int[]{3,2});
        graph.get(1).add(new int[]{4,3});
        graph.get(3).add(new int[]{0,2});
        graph.get(3).add(new int[]{1,2});
        graph.get(3).add(new int[]{4,2});
        graph.get(3).add(new int[]{5,3});
        graph.get(4).add(new int[]{1,3});
        graph.get(4).add(new int[]{3,2});
        graph.get(4).add(new int[]{6,2});
        graph.get(5).add(new int[]{3,3});
        graph.get(5).add(new int[]{6,3});
        graph.get(6).add(new int[]{2,4});
        graph.get(6).add(new int[]{4,2});
        graph.get(6).add(new int[]{5,3});
        BestFirstSearch test = new BestFirstSearch();
        List<Integer> res = test.dijkstra(graph, 0, 6);
        for(int i : res) {
            System.out.println(i);
        }
    }
}
