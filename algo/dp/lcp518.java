package algo.dp;

/**
 * 1、
 * 2、
 * 3、
 * 4、
 * 5、重复计算，更换遍历次序
 */
public class lcp518 {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount+1];
        dp[0] = 1;
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i - coin < 0) continue;
                dp[i] += dp[i-coin];
            }
        }
        return dp[amount];
    }
}
