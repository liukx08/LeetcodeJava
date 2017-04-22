import java.util.*;

/**
 * Created by liukx08 on 4/22/2017.
 */
public class RandomizedSet {

    Map<Integer, Integer> map;

    List<Integer> list;

    /** Initialize your data structure here. */
    public RandomizedSet() {
        // use map to achieve O(1) lookup
        map = new HashMap<>();
        // use list to achieve O(1) random get
        list = new ArrayList<>();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        // val exists in the random set
        if(map.containsKey(val)) {
            return false;
        }
        // add val into list and put val/index into map
        map.put(val, list.size());
        list.add(val);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        // val doesn't exist in the random set
        if(!map.containsKey(val)) {
            return false;
        }
        // use map to acquire the index of val
        int idx = map.get(val);
        // swap val and the last element in the list
        map.put(list.get(list.size() - 1), idx);
        list.set(idx, list.get(list.size() - 1));
        // remove val
        list.remove(list.size() - 1);
        map.remove(val);
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        Random rand = new Random();
        return list.get(rand.nextInt(list.size()));
    }
}
