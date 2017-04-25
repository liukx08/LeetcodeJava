import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by liukx08 on 4/24/2017.
 *
 *          two methods: 1. store word word pairs and their distance: O(n^2) and O(1)
 *                       2. store word and its index: O(n) and less than O(n)
 *
 *                       2 is better than 1 since O(n) for initialization is much less than
 *                       O(n^2). calculating distance is close to O(1) if there are few duplicates
 */
public class ShortestWordDistanceII_244 {

    Map<String, List<Integer>> index;

    public ShortestWordDistanceII_244(String[] words) {
        // use hash map to record each word and all its index, O(n)
        index = new HashMap<>();
        for(int i = 0; i < words.length; i++) {
            if(!index.containsKey(words[i])) {
                index.put(words[i], new ArrayList<Integer>());
            }
            index.get(words[i]).add(i);
        }
    }
        // find closest two index of word 1 and word 2, less than O(n), O(n) most
    public int shortest(String word1, String word2) {
        List<Integer> idx1 = index.get(word1);
        List<Integer> idx2 = index.get(word2);
        int i = 0, j = 0, min = Integer.MAX_VALUE;
        while(i < idx1.size() && j < idx2.size()) {
            int idxi = idx1.get(i), idxj = idx2.get(j);
            if(idxi < idxj) {
                min = Math.min(idxj - idxi, min);
                i++;
            } else {
                min = Math.min(idxi - idxj, min);
                j++;
            }
        }
        return min;
    }
}
