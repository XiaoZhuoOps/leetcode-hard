package basic.dp;

import java.util.Arrays;

/**
 * 1、从dfs出发发现重复子问题，属于无限背包问题
 * 2、状态 dp[i] 金额为i的零钱组合数的最小值 状态转移方程 dp[i] = min{dp[i-coin] | coin in coins}+1
 * 3、注意没有任何一种硬币组合能组成总金额的情况
 */
public class lc322 {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp, amount+1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i - coin >= 0){
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
                //若没有任何一种硬币组合能组成总金额，dp[i]保持不变
            }
        }
        return (dp[amount] == amount+1) ? -1 : dp[amount];
    }
}
