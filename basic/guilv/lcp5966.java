package basic.guilv;

import java.util.Arrays;

public class lcp5966 {
}
//规律题
class Lcp5966 {
    public int[] recoverArray(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        for (int i = 1; i < len; i++) {
            int k2 = nums[i] - nums[0];
            if (k2 <= 0 || k2%2 != 0) continue;
            int left = 0, right = i;
            int[] res = new int[len/2];
            int r = 0;
            res[0] = nums[0] + k2/2;
            boolean[] vis = new boolean[len];
            vis[0] = vis[i] = true;
            while (left < len) {
                while (left < len && vis[left]) {
                    left++;
                }
                if (left == len) {
                    return res;
                }
                while (right < len && (vis[right] || (nums[right] != nums[left] + k2))) {
                    right++;
                }
                if (right == len) {
                    break;
                } else {
                    vis[left] = vis[right] = true;
                    res[r++] = nums[left] + k2/2;
                }
            }
        }
        return null;
    }
}
