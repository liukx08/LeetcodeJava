import java.util.*;

/**
 * Created by liukx08 on 5/14/2017.
 */
public class SequenceReconstruction_444 {
    public boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs) {
        if(org == null || org.length == 0 || seqs == null || seqs.size() == 0) {
            return false;
        }
        if(org.length == 1) {
            boolean res = false;
            for(int i = 0; i < seqs.size(); i++) {
                if(seqs.get(i).size() > 1) {
                    return false;
                }
                if(seqs.get(i).size() == 1 && seqs.get(i).get(0) == org[0]) {
                    res = true;
                }
            }
            return res;
        }
        int[] indegree = new int[org.length + 1];
        Set<Integer>[] next = new Set[org.length + 1];
        for(int i = 0; i < seqs.size(); i++) {
            Integer[] seq = seqs.get(i).toArray(new Integer[0]);
            if(seq.length == 1 && (seq[0] < 1 || seq[0] > org.length)) {
                return false;
            }
            for(int j = 1; j < seq.length; j++) {
                if(seq[j - 1] < 1 || seq[j - 1] > org.length || seq[j] < 1 || seq[j] > org.length) {
                    return false;
                }
                if(next[seq[j - 1]] == null) {
                    next[seq[j - 1]] = new HashSet<>();
                }
                if(!next[seq[j - 1]].contains(seq[j])) {
                    indegree[seq[j]]++;
                    next[seq[j - 1]].add(seq[j]);
                }
            }
        }
        Deque<Integer> queue = new ArrayDeque<>();
        for(int i = 1; i < indegree.length; i++) {
            if(indegree[i] == 0) {
                queue.offer(i);
            }
        }
        for(int i = 0; i < org.length; i++) {
            if(queue.size() != 1) {
                return false;
            }
            int curr = queue.poll();
            if(curr != org[i]) {
                return false;
            }
            if(next[curr] != null) {
                for(int nei : next[curr]) {
                    if(--indegree[nei] == 0) {
                        queue.offer(nei);
                    }
                }
            }
        }
        return true;
    }
}
