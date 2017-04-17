import java.util.List;

/**
 * Created by liukx08 on 4/16/2017.
 *      for each candidate word(length m), check
 *      if substring(0, n - m) can be broken && substring(n - m, n) is in the dictionary
 */
public class WordBreak_139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] lookup = new boolean[s.length() + 1];
        lookup[0] = true; // base case: null word
        for(int i = 1; i <= s.length(); i++){
            for(String str: wordDict){
                // induction
                if(str.length() <= i && lookup[i - str.length()] && s.substring(i - str.length(), i).equals(str)) {
                    lookup[i] = true;
                    break;
                }
            }
        }
        return lookup[s.length()];
    }
}
