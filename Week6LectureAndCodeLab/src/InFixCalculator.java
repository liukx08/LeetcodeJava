import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by liukx08 on 4/28/2017.
 */
public class InFixCalculator {
    public int evalInFix(char[] tokens) {
        // operand stack
        Deque<Integer> valStack = new ArrayDeque<>();
        // operator stack
        Deque<Character> opStack = new ArrayDeque<>();
        for(int i = 0; i < tokens.length; i++) {
            if(tokens[i] == '(') {
                // negative integer operand
                if(tokens[i + 1] == '-') {
                    int j = i + 2;
                    while(Character.isDigit(tokens[j])) {
                        j++;
                    }
                    valStack.push(Integer.parseInt(new String(tokens, i + 1, j - i - 1)));
                    i = j;
                } else { // normal bracket
                    opStack.push(tokens[i]);
                }
            } else if(tokens[i] == ')') {
                while(opStack.peek() != '(') {
                    valStack.push(calc(opStack.pop(), valStack.pop(), valStack.pop()));
                }
                opStack.pop();
            } else if (tokens[i] == '+' || tokens[i] == '-' || tokens[i] == '*' || tokens[i] == '/') {
                // previous operator has higher priority
                if(!opStack.isEmpty() && (tokens[i] == '+' || tokens[i] == '-') && (opStack.peek() == '*' || opStack.peek() == '/')) {
                    valStack.push(calc(opStack.pop(), valStack.pop(), valStack.pop()));
                }
                opStack.push(tokens[i]);
            } else {
                int j = i + 1;
                while(j < tokens.length && Character.isDigit(tokens[j])) {
                    j++;
                }
                valStack.push(Integer.parseInt(new String(tokens, i, j - i)));
                i = j - 1;
            }
        }
        while(!opStack.isEmpty()) {
            valStack.push(calc(opStack.pop(), valStack.pop(), valStack.pop()));
        }
        return valStack.pop();
    }

    public int calc(char op, int a, int b) {
        switch(op) {
            case '+':
                return b + a;
            case '-':
                return b - a;
            case '*':
                return b * a;
            case '/':
                return b / a;
        }
        return -1;
    }

    public static void main(String[] args) {
        InFixCalculator test = new InFixCalculator();
        String s = "(8+4)/(2-14)+2*((-20)+1)";
        System.out.println(test.evalInFix(s.toCharArray()));
    }
}
