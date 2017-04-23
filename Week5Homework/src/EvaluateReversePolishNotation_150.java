import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by liukx08 on 4/23/2017.
 */
public class EvaluateReversePolishNotation_150 {
    public int evalRPN(String[] tokens) {
        if(tokens == null || tokens.length == 0) {
            return 0;
        }
        // use stack
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i = 0; i < tokens.length; i++) {
            if(Character.isDigit(tokens[i].charAt(tokens[i].length() - 1))) {
                stack.push(stringToNumber(tokens[i]));
            } else {
                int second = stack.pop();
                int first = stack.pop();
                if(tokens[i].equals("+")) {
                    stack.push(first + second);
                } else if(tokens[i].equals("-")) {
                    stack.push(first - second);
                } else if(tokens[i].equals("*")) {
                    stack.push(first * second);
                } else {
                    stack.push(first / second);
                }
            }
        }
        return stack.pop();
    }
    // can also use Integer.parseInt(String)
    private int stringToNumber(String number) {
        int res = 0;
        if(number.charAt(0) == '-') {
            for(int i = 1; i < number.length(); i++) {
                res = 10 * res + number.charAt(i) - '0';
            }
            return -res;
        }
        for(int i = 0; i < number.length(); i++) {
            res = 10 * res + number.charAt(i) - '0';
        }
        return res;
    }
}
