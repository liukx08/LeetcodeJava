/**
 * Created by liukx08 on 4/22/2017.
 */
public class LoadLimit {

    private Token[] circularArray;
    int start;
    int end;
    // array full flag
    boolean isFull;
    private int timeLimit;
    private int hitLimit;

    public static class Token {
        int timeStamp;
        int val;
        public Token(int timeStamp, int val) {
            this.timeStamp = timeStamp;
            this.val = val;
        }
    }

    public LoadLimit(int timeLimit, int hitLimit) {
        circularArray = new Token[hitLimit];
        this.timeLimit = timeLimit;
        this.hitLimit = hitLimit;
        start = 0;
        end = 0;
        isFull = false;
    }

    public boolean hit(Token token) {
        // reached to hit limit
        if(isFull) {
            Token first = circularArray[start];
            // discard expired request, add new hit in to
            if(token.timeStamp - first.timeStamp >= timeLimit) {
                circularArray[end] = token;
                end = (end + 1) % hitLimit;
                start = end;
                return true;
            } else {    // request too frequently, refuse hit request
                return false;
            }
        }
        // not full, add new into array
        circularArray[end] = token;
        end = (end + 1) % hitLimit;
        if(start == end) {
            isFull = true;
        }
        return true;
    }

    public boolean digest() {
        // empty array, no hit to digest
        if(!isFull && start == end) {
            return false;
        }
        // digest the first hit
        circularArray[start] = null;
        start = (start + 1) % hitLimit;
        isFull = false;
        return true;
    }

    public static void main(String[] args) {
        LoadLimit test = new LoadLimit(4, 5);
        System.out.println("==== Test Case 1 ====");
        System.out.println(test.hit(new Token(1, 1)));
        System.out.println(test.hit(new Token(2, 2)));
        System.out.println(test.hit(new Token(3, 3)));
        System.out.println(test.hit(new Token(3, 4)));
        System.out.println(test.hit(new Token(4, 5)));
        System.out.println(test.hit(new Token(4, 6)));
        System.out.println(test.hit(new Token(10, 7)));
        test = new LoadLimit(4, 5);
        System.out.println("==== Test Case 2 ====");
        System.out.println(test.digest());
        System.out.println(test.hit(new Token(1, 1)));
        System.out.println(test.hit(new Token(2, 2)));
        System.out.println(test.hit(new Token(3, 3)));
        System.out.println(test.hit(new Token(3, 4)));
        System.out.println(test.digest());
        System.out.println(test.hit(new Token(4, 5)));
        System.out.println(test.hit(new Token(4, 6)));
        System.out.println(test.hit(new Token(4, 7)));
    }
}
