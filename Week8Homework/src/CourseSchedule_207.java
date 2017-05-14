import java.util.*;

/**
 * Created by liukx08 on 5/14/2017.
 */
public class CourseSchedule_207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(numCourses == 0 || prerequisites == null || prerequisites.length == 0) {
            return true;
        }
        Map<Integer, List<Integer>> pre = new HashMap<>();
        int[] indegree = new int[numCourses];
        for(int[] curr : prerequisites) {
            if(!pre.containsKey(curr[1])) {
                pre.put(curr[1], new ArrayList<>());
            }
            pre.get(curr[1]).add(curr[0]);
            indegree[curr[0]]++;
        }
        Deque<Integer> queue = new ArrayDeque<>();
        for(int i = 0; i < numCourses; i++) {
            if(indegree[i] == 0) {
                queue.offer(i);
            }
        }
        int count = 0;
        while(!queue.isEmpty()) {
            int course = queue.poll();
            count++;
            if(pre.containsKey(course)) {
                for(int next : pre.get(course)) {
                    if(--indegree[next] == 0) {
                        queue.offer(next);
                    }
                }
            }
        }
        return count == numCourses;
    }
}
