import java.util.ArrayList;
import java.util.List;

/**
 * Created by liukx08 on 4/22/2017.
 */
public class GenerateParentheses_22 {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        helper(n, n, new String(""), res);
        return res;
    }
    // DFS: "left" track remained left parentheses, "right" track remained right parentheses
    private void helper(int left, int right, String ans, List<String> res) {
        if(right == 0) {
            res.add(ans);
            return;
        }
        // if remained left parentheses equal right parentheses
        if (left == right) {
            helper(left - 1, right, ans + "(", res);
        } else { // either add a left parenthesis or a right parenthesis
            if(left != 0) {
                helper(left - 1, right, ans + "(", res);
            }
            helper(left, right - 1, ans + ")", res);
        }
    }
}
