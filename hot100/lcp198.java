package hot100;

/**
 * 刷表法
 * dp[i] 表示第i间房子可选或不可选的情况下获得的最大分数
 * 若选了第i间房子，则更新dp[i+2];没有选，则更新dp[i+1]
 * 注意i越界的情况
 */
public class lcp198 {
    public int rob(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len + 1];
        dp[0] = 0;
        for (int i = 0; i < len; i++) {
            if (i + 2 <= len) {
                dp[i + 2] = Math.max(dp[i + 2], dp[i] + nums[i]);
            } else {
                dp[len] = Math.max(dp[len], dp[i] + nums[i]);
            }
            dp[i + 1] = Math.max(dp[i + 1], dp[i]);
        }
        return dp[len];
    }
}
