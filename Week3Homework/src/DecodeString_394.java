/**
 * Created by liukx08 on 4/9/2017.
 */
import java.util.Deque;
import java.util.ArrayDeque;

public class DecodeString_394 {
    // use stack to do DFS
    public String decodeString(String s) {
        String res="";
        Deque<String> prefixStack=new ArrayDeque<>();   // stack to store prefix letters
        Deque<Integer> countStack=new ArrayDeque<>();   // stack to store counting times
        int i=0;
        while(i<s.length()){
            if(Character.isDigit(s.charAt(i))){     // read repeat number k and push it into countStack
                int count=0;
                while(Character.isDigit(s.charAt(i)))count=10*count+s.charAt(i++)-'0';
                countStack.push(count);
            } else if(s.charAt(i)=='['){    // push prefix
                prefixStack.push(res);
                res="";
                i++;
            } else if(s.charAt(i)==']'){    // pop repeat number k and prefix, append res to prefix k times
                StringBuilder tmp=new StringBuilder(prefixStack.pop());
                int j=countStack.pop();
                while(j>0){
                    tmp.append(res);
                    j--;
                }
                res=tmp.toString();
                i++;
            } else{     // append letter to res directly
                res+=s.charAt(i++);
            }
        }
        return res;
    }

    // DFS recursively call decodeString
    public String decodeString2(String s) {
        StringBuilder res=new StringBuilder();
        int i=0;
        // append prefix letters
        while(i<s.length()&&Character.isLetter(s.charAt(i))){
            res.append(s.charAt(i++));
        }
        if(i>=s.length())return new String(res); // return if at end
        // read repeated times to 'count'
        int count=0;
        while(Character.isDigit(s.charAt(i))){
            count=10*count+s.charAt(i++)-'0';
        }
        // find substring in []
        int j=i+1,stack=1;
        while(stack!=0){
            if(s.charAt(j)=='[')stack++;
            if(s.charAt(j)==']')stack--;
            j++;
        }
        // append substring in [] for 'count' times
        while(count>0){
            res.append(decodeString(s.substring(i+1,j-1)));
            count--;
        }
        // append left string at tail
        if(j<s.length())res.append(decodeString(s.substring(j,s.length())));
        return new String(res);
    }

    public static void main(String[] args){
        DecodeString_394 test=new DecodeString_394();
        test.decodeString("10[leetcode]");
    }
}
