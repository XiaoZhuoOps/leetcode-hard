package algo.interval;

public class lc238 {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] right = new int[len], res = new int[len];
        int left = 1;
        right[len-1] = 1;
        for (int i = len-2; i >= 0; i--) {
            right[i] = right[i+1] * nums[i+1];
        }
        res[0] = right[0];
        for (int i = 1; i < len; i++) {
            left *= nums[i-1];
            res[i] = left * right[i];
        }
        return res;
    }
}
