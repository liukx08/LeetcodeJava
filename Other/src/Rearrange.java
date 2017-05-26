import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by liukx08 on 5/26/2017.
 *
 *   rearrange characters in a string such that no two adjacent are the same
 *   priority queue
 *
 *
 */
public class Rearrange {
    int[] alphabetic = new int[27];

    public String rearrange(String str) {
        if(str.isEmpty()) {
            return "";
        }
        char[] letters = str.toCharArray();
        PriorityQueue<Character> queue = new PriorityQueue<>(new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                if(alphabetic[o1 - 'a'] > alphabetic[o2 - 'a']) {
                    return -1;
                }
                if(alphabetic[o1 - 'a'] == alphabetic[o2 - 'a']) {
                    return 0;
                }
                return 1;
            }
        });
        for(char c : letters) {
            alphabetic[c - 'a']++;
        }
        for(int i = 0; i < 26; i++) {
            if(alphabetic[i] != 0) {
                queue.offer((char)('a' + i));
            }
        }
        char prev = (char)('a' + 26);
        StringBuilder res = new StringBuilder();
        while(!queue.isEmpty()) {
            char c = queue.poll();
            res.append(c);
            alphabetic[c - 'a']--;
            if(alphabetic[prev - 'a'] > 0) {
                queue.offer(prev);
            }
            prev = c;
        }
        return res.length() == letters.length ? res.toString() : "";
    }

    public static void main(String[] args) {
        Rearrange test = new Rearrange();
        System.out.println(test.rearrange("aaaabbkjfllaksaaonnnebbbbaaa"));
    }
}
