import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by liukx08 on 5/11/2017.
 */
public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> words = new HashSet<>();
        for(String word : wordList) {
            words.add(word);
        }
        if(!words.contains(endWord) || words.size() == 0) {
            return 0;
        }
        return bfsHelper(beginWord, endWord, words);
    }

    private int bfsHelper(String beg, String end, Set<String> wordList) {
        Set<String> visited = new HashSet<>();
        Set<String> begSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();
        int steps = 0;
        begSet.add(beg);
        endSet.add(end);
        visited.add(beg);
        visited.add(end);
        while(!begSet.isEmpty() && !endSet.isEmpty()) {
            if(begSet.size() > endSet.size()) {
                Set<String> tmp = begSet;
                begSet = endSet;
                endSet = tmp;
            }
            steps++;
            Set<String> nextLevel = new HashSet<String>();
            for(String curr : begSet) {
                for(int i = 0; i < curr.length(); i++) {
                    for(char c = 'a'; c <= 'z'; c++) {
                        String next = transform(curr, i, c);
                        if(endSet.contains(next)) {
                            return ++steps;
                        }
                        if(wordList.contains(next) && visited.add(next)) {
                            nextLevel.add(next);
                        }
                    }
                }
            }
            begSet = nextLevel;
        }
        return 0;
    }

    private String transform(String curr, int idx, char c) {
        char[] next = curr.toCharArray();
        next[idx] = c;
        return String.valueOf(next);
    }
}
