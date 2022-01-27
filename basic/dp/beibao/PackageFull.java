package basic.dp.beibao;

/**
 * 1、完全背包
 * 2、dp[i][j] 前i个物品，容量为j的情况下能获得的最大分数
 * 依据第i件物品的选择个数来划分集合 dp[i][j] = max{dp[i-1][j], dp[i-1][j-v[i-1]]+w[i-1],,,} = max{dp[i-1][j-k*v[i-1]]+k*w[i-1]}
 * 观察规律得 dp[i][j] = max{dp[i-1][j], dp[i][j-v[i-1]]+w[i-1]]
 * 空间复杂度 O(n2) 转移方程只用到了i和i-1 可以消去
 * 3、
 */
public class PackageFull {
    int packageFull(int[] vs, int[] ws, int c) {
        int len = vs.length;
        int[] dp = new int[len + 1];
        dp[0] = 0;
        for (int i = 1; i <= len; i++) {
            for (int j = len; j >= 0; j--) {
                if (j - vs[i - 1] >= 0) {
                    dp[j] = Math.max(dp[j], dp[j - vs[i - 1]] + ws[i - 1]);
                }
                // else dp[j] = dp[j]
            }
        }
        return dp[len];
    }
}
