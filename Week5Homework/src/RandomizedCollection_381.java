import java.util.*;

/**
 * Created by liukx08 on 4/24/2017.
 */
public class RandomizedCollection_381 {
    Map<Integer, Set<Integer>> cache;
    List<Integer> list;

    /** Initialize your data structure here. */
    public RandomizedCollection_381() {
        cache = new HashMap<>();
        list = new ArrayList<>();
    }

    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        boolean exist = cache.containsKey(val);
        // use a LinkedHashSet to store the index of elements with val in list
        if(!exist) {
            cache.put(val, new LinkedHashSet<>());
        }
        cache.get(val).add(list.size());
        list.add(val);
        return !exist;
    }

    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if(!cache.containsKey(val)) {
            return false;
        }
        int idx = cache.get(val).iterator().next();
        cache.get(val).remove(idx);
        if(idx < list.size() - 1) {
            int lastval = list.get(list.size() - 1);
            list.set(idx, lastval);
            cache.get(lastval).remove(list.size() - 1);
            cache.get(lastval).add(idx);
        }
        list.remove(list.size() - 1);
        if(cache.get(val).size() == 0) {
            cache.remove(val);
        }
        return true;
    }

    /** Get a random element from the collection. */
    public int getRandom() {
        return list.get(new Random().nextInt(list.size()));
    }
}
