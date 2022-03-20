package LCP.DCP74;

import java.util.Arrays;

public class L1 {
    public boolean divideArray(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i+=2) {
            if (nums[i] != nums[i+1]) return false;
        }
        return true;
    }
}
