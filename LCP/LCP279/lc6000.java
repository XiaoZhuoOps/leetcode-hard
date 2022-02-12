package LCP.LCP279;

import java.util.*;

public class lc6000 {
    public int[] sortEvenOdd(int[] nums) {
        List<Integer> odd = new ArrayList<>();
        List<Integer> even = new ArrayList<>();
        int len = nums.length;

        for (int i = 0; i < len; i++) {
            if (i%2 == 0) {
                even.add(nums[i]);
            } else {
                odd.add(nums[i]);
            }
        }
        odd.sort((o1, o2) -> {
            return o2 - o1;
        });
        even.sort((o1, o2) -> {
            return o1 - o2;
        });
        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            if (i%2 == 0) res[i] = even.get(i/2);
            else res[i] = odd.get(i/2);
        }
        return res;
    }
}
