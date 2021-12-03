package basic.dp;

import java.util.HashMap;
import java.util.Map;

public class lc1218 {
    public int longestSubsequence(int[] arr, int difference) {
        int res = 1;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = arr.length-1; 0 <= i; i--) {
            if (map.containsKey(arr[i] + difference)) {
                int len = map.get(arr[i] + difference) + 1;
                res = Math.max(res, len);
                map.put(arr[i], len);
            } else {
                map.put(arr[i], 1);
            }
        }
        return res;
    }
}
