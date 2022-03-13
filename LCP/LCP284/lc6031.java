package LCP.LCP284;

import java.util.ArrayList;
import java.util.List;

public class lc6031 {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        List<Integer> keyIndexs = new ArrayList<>();
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (nums[i] == key) keyIndexs.add(i);
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            for (int j : keyIndexs) {
                if (Math.abs(i-j) <= k) {
                    ans.add(i);
                    break;
                }
            }
        }
        return ans;
    }
}
