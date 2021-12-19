package basic.DS.Custom;

import java.util.*;

public class lc380 {
}
class RandomizedSet {
    List<Integer> list;
    Map<Integer, Integer> map; //val -> index
    Random rand = new Random();
    public RandomizedSet() {
        list = new ArrayList<>();
        map = new HashMap<>();
    }
    public boolean insert(int val) {
       if (map.containsKey(val)) {
           return false;
       } else {
           list.add(val);
           map.put(val, list.size()-1);
           return true;
       }
    }
    public boolean remove(int val) {
        if (map.containsKey(val)) {
            int index = map.get(val), last = list.size()-1, lastVal = list.get(last);
            list.set(index, lastVal);
            list.remove(last);
            map.put(lastVal, index);
            map.remove(val);
            return true;
        } else {
            return false;
        }
    }
    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }
}
