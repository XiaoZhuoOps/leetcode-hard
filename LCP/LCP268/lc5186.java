package LCP.LCP268;

import java.util.*;

public class lc5186 {
}

class RangeFreqQuery {

    Map<Integer, List<Integer>> map;
    int[] arr;

    public RangeFreqQuery(int[] arr) {
        this.arr = arr;
        this.map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                List<Integer> fs = map.get(arr[i]);
                fs.add(i);
                map.put(arr[i], fs);
            } else {
                ArrayList<Integer> fs = new ArrayList<>();
                fs.add(i);
                map.put(arr[i], fs);
            }
        }
    }

    public int query(int left, int right, int value) {
        List<Integer> fs = map.get(value);
        if (fs == null) return 0;
        return findFreq(value, right, fs) - findFreq(value, left - 1, fs);
    }

    int findFreq(int value, int index, List<Integer> fs) {
        int left = 0, right = fs.size() - 1;
        while (left < right) {
            int mid = (right + left + 1) / 2;
            if (fs.get(mid) <= index) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return (fs.get(left) >= index) ? (left + 1) : 0;
    }
}
