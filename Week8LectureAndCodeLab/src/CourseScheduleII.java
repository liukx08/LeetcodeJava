import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Created by liukx08 on 5/13/2017.
 */
public class CourseScheduleII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if(numCourses < 1) {
            return new int[0];
        }
        int[] res = new int[numCourses];
        if(prerequisites == null || prerequisites.length == 0) {
            for(int i = 0; i < numCourses; i++) {
                res[i] = i;
            }
            return res;
        }
        List<Integer>[] nextCourse = new List[numCourses];
        int[] baseCourse = new int[numCourses];
        for(int[] pre : prerequisites) {
            if(nextCourse[pre[1]] == null) {
                nextCourse[pre[1]] = new ArrayList<>();
            }
            nextCourse[pre[1]].add(pre[0]);
            baseCourse[pre[0]]++;
        }
        Deque<Integer> queue = new ArrayDeque<>();
        for(int i = 0; i < numCourses; i++) {
            if(baseCourse[i] == 0) {
                queue.offer(i);
            }
        }
        int i = 0;
        while(!queue.isEmpty()) {
            int course = queue.poll();
            res[i++] = course;
            if(nextCourse[course] != null) {
                for(int next : nextCourse[course]) {
                    baseCourse[next]--;
                    if(baseCourse[next] == 0) {
                        queue.offer(next);
                    }
                }
            }
        }
        return i == numCourses ? res : new int[0];
    }
}
