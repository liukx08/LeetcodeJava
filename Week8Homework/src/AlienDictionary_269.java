import java.util.HashMap;
import java.util.Map;

/**
 * Created by liukx08 on 5/14/2017.
 */
public class AlienDictionary_269 {
    public String alienOrder(String[] words) {
        if(words == null || words.length == 0) {
            return "";
        }
        if(words.length == 1) {
            return words[0];
        }
        int[] indegree = new int[26];
        boolean[] letters = new boolean[26];
        Map<Character, StringBuilder> order = new HashMap<>();
        for(int i = 1; i < words.length; i++) {
            findOrder(indegree, order, words[i - 1].toCharArray(), words[i].toCharArray(), letters);
        }
        StringBuilder res = new StringBuilder();
        for(int i = 0; i < 26; i++) {
            if(letters[i] && indegree[i] == 0) {
                res.append((char)('a' + i));
            }
        }
        int i = 0;
        while(i < res.length()) {
            char key = res.charAt(i);
            if(order.containsKey(key)) {
                for(char next : order.get(key).toString().toCharArray()) {
                    int idx = next - 'a';
                    if(--indegree[idx] == 0) {
                        res.append(next);
                    }
                }
            }
            i++;
        }
        for(i = 0; i < 26; i++) {
            if(indegree[i] != 0) {
                return "";
            }
        }
        return res.toString();
    }

    private void findOrder(int[] indegree, Map<Character, StringBuilder> order, char[] former, char[] latter, boolean[] letters) {
        int i = 0, j = 0;
        while(i < former.length && j < latter.length && former[i] == latter[j]) {
            letters[former[i] - 'a'] = true;
            i++;
            j++;
        }
        if(i < former.length && j < latter.length) {
            if(!order.containsKey(former[i])) {
                order.put(former[i], new StringBuilder());
            }
            order.get(former[i]).append(latter[j]);
            indegree[latter[j] - 'a']++;
        }
        while(i < former.length) {
            letters[former[i++] - 'a'] = true;
        }
        while(j < latter.length) {
            letters[latter[j++] - 'a'] = true;
        }
    }
}
