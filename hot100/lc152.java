package hot100;

/**
 *
 */
public class lc152 {
    public int maxProduct(int[] nums) {
        int lastMax = nums[0], lastMin = nums[0];
        int max = lastMax, min = lastMin, res = lastMax;
        for (int i = 1; i < nums.length; res = Math.max(res, max), i++, lastMax = max, lastMin = min) {
            max = Math.max(Math.max(lastMax*nums[i], lastMin*nums[i]), nums[i]);
            min = Math.min(Math.min(lastMax*nums[i], lastMin*nums[i]), nums[i]);
        }
        return res;
    }
}
