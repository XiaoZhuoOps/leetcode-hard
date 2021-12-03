package LCP.LCP269;

import java.util.Arrays;

public class lcp5940 {
    public int minimumDeletions(int[] nums) {
        int a = 0, b = 0, min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < min) {
                a = i; min = nums[i];
            }
            if (nums[i] > max) {
                b = i; max = nums[i];
            }
        }

        if (a > b) {
            int temp = a;
            a = b;
            b = temp;
        }

        int[] res = new int[]{a, b-a-1, nums.length-b-1};
        Arrays.sort(res);
        return res[0] + res[1] + 2;
    }
}
