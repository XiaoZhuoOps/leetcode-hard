package LCP.LCP269;

public class lcp5939 {
    public int[] getAverages(int[] nums, int k) {
        int len = nums.length;
        long[] preSum = new long[len];
        preSum[0] = nums[0];
        for (int i = 1; i < len; i++) {
            preSum[i] = preSum[i-1] + nums[i];
        }

        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            if (i-k<0 || i+k >= len) {
                res[i] = -1;
                continue;
            }
            if (i-k == 0) {
                res[i] = (int) (preSum[i+k] / (2*k-1));
                continue;
            }
            res[i] = (int) ((preSum[i+k] - preSum[i-k-1]) / (2*k-1));
        }
        return res;
    }
}
