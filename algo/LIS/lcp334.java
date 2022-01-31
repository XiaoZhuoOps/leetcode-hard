package algo.LIS;

import java.util.ArrayList;
import java.util.List;

public class lcp334 {
    public boolean increasingTriplet(int[] nums) {
        List<Integer> lis = new ArrayList<>();
        lis.add(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            int small = -1;
            for (int j = 0; j < lis.size(); j++) {
                if (nums[i] > lis.get(j)) {
                    small = j;
                }
            }
            if (small == lis.size()-1) {
                lis.add(nums[i]);
            } else lis.set(small+1, nums[i]);
        }
        return lis.size() > 2;
    }
}