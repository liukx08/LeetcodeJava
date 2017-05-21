import java.util.List;

/**
 * Created by liukx08 on 5/21/2017.
 */
public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] lookup = new boolean[s.length() + 1];
        lookup[0] = true;
        for(int i = 1; i <= s.length(); i++){
            for(String str: wordDict){
                if(str.length() <= i && lookup[i - str.length()] && s.substring(i - str.length(), i).equals(str)) {
                    lookup[i] = true;
                    break;
                }
            }
        }
        return lookup[s.length()];
    }
}
