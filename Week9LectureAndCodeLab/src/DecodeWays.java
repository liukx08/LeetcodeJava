/**
 * Created by liukx08 on 5/22/2017.
 */
public class DecodeWays {
    public int numDecodings(String s) {
        if(s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }
        int prev = 1;
        int curr = 1;
        for(int i = 1; i < s.length(); i++) {
            int next = 0;
            if(s.charAt(i) == '0') {
                if(s.charAt(i - 1) != '1' && s.charAt(i - 1) != '2') {
                    return 0;
                }
                next = prev;
            } else if(s.charAt(i - 1) - '0' == 1 || (s.charAt(i - 1) == '2' && s.charAt(i) - '0' <= 6)) {
                next = curr + prev;
            } else {
                next = curr;
            }
            prev = curr;
            curr = next;
        }
        return curr;
    }
}
