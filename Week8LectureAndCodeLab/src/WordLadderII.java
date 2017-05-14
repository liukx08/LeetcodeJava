import java.util.*;

/**
 * Created by liukx08 on 5/13/2017.
 */
public class WordLadderII {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>();
        dict.addAll(wordList);
        List<List<String>> res = new ArrayList<>();
        if(dict.size() == 0 || !dict.contains(endWord)) {
            return res;
        }
        Set<String> start = new HashSet<>();
        Set<String> end = new HashSet<>();
        Map<String, List<String>> neighbors = new HashMap<>();
        start.add(beginWord);
        end.add(endWord);
        if(find(start, end, neighbors, dict, false)) {
            List<String> path = new ArrayList<>();
            path.add(beginWord);
            buildPath(beginWord, endWord, neighbors, path, res);
        }
        return res;
    }

    private boolean find(Set<String> start, Set<String> end, Map<String, List<String>> nei, Set<String> dict, boolean swap) {
        if(start.size() > end.size()) {
            return find(end, start, nei, dict, !swap);
        }
        Set<String> next = new HashSet<String>();
        boolean found = false;
        dict.removeAll(start);
        for(String curr : start) {
            for(int i = 0; i < curr.length(); i++) {
                char[] str = curr.toCharArray();
                for(char c = 'a'; c <= 'z'; c++) {
                    str[i] = c;
                    String temp = String.valueOf(str);
                    if(end.contains(temp) || dict.contains(temp)) {
                        if(end.contains(temp)) {
                            found = true;
                        } else {
                            next.add(temp);
                        }
                        String key = swap ? temp : curr;
                        String value = swap ? curr : temp;
                        if(!nei.containsKey(key)) {
                            nei.put(key, new ArrayList<>());
                        }
                        nei.get(key).add(value);
                    }
                }
            }
        }
        if(found) {
            return true;
        }
        if(next.isEmpty()) {
            return false;
        }
        return find(next, end, nei, dict, swap);
    }

    private void buildPath(String beg, String end, Map<String, List<String>> nei, List<String> onePath, List<List<String>> res) {
        if(beg.equals(end)) {
            res.add(new ArrayList(onePath));
            return;
        }
        if(nei.containsKey(beg)) {
            for(String next : nei.get(beg)) {
                onePath.add(next);
                buildPath(next, end, nei, onePath, res);
                onePath.remove(onePath.size() - 1);
            }
        }
    }
}
