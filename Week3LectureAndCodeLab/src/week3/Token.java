package week3;

/**
 * Created by liukx08 on 4/14/2017.
 */
public class Token {
    private int val;

    private String name;

    public Token(int val, String name) {
        this.name = name;
        this.val = val;
    }

    @Override
    public String toString() {
        return name + " " + val;
    }
}
