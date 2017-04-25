import java.util.BitSet;

/**
 * Created by liukx08 on 4/24/2017.
 *
 *      use a bitset: index is phone number, value is using state
 */
public class PhoneDirectory_379 {
    BitSet directory;
    int max;
    int next;

    /** Initialize your data structure here
     @param maxNumbers - The maximum numbers that can be stored in the phone directory. */
    public PhoneDirectory_379(int maxNumbers) {
        directory = new BitSet(maxNumbers);
        max = maxNumbers;
        next = 0;
    }

    /** Provide a number which is not assigned to anyone.
     @return - Return an available number. Return -1 if none is available. */
    public int get() {
        if(next == max) {
            return -1;
        }
        int number = next;
        directory.set(next);
        next = directory.nextClearBit(next);
        return number;
    }

    /** Check if a number is available or not. */
    public boolean check(int number) {
        if(number >= max || number < 0) {
            return false;
        }
        return !directory.get(number);
    }

    /** Recycle or release a number. */
    public void release(int number) {
        if(!directory.get(number)) {
            return;
        }
        directory.clear(number);
        if(number < next) {
            next = number;
        }
    }
}
