/**
 * Created by liukx08 on 4/23/2017.
 *
 */
public class SortCharactersByFrequency_451 {
    // bucket sort
    public String frequencySort(String s) {
        // count the frequency of each character
        char[] str = s.toCharArray();
        int[] count = new int[128];
        int max = 0;
        for(int i = 0; i < str.length; i++) {
            count[str[i]]++;
            max = Math.max(count[str[i]], max);
        }
        // bucket sort
        StringBuilder[] strs = new StringBuilder[max + 1];
        for(int i = 0; i < 128; i++) {
            if(count[i] != 0) {
                if(strs[count[i]] == null) {
                    strs[count[i]] = new StringBuilder();
                }
                for(int j = 0; j < count[i]; j++) {
                    strs[count[i]].append((char)i);
                }
            }
        }
        // assemble result by frequency order
        StringBuilder res = new StringBuilder();
        for(int i = max; i > 0; i--) {
            if(strs[i] != null) {
                res.append(strs[i]);
            }
        }
        return res.toString();
    }
}
