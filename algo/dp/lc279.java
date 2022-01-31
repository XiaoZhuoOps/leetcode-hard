package algo.dp;

import java.util.ArrayList;
import java.util.List;

/**
 * 1、完全背包问题
 * 2、dp[i][j] 用前i个完全平方数，恰好组成j的最小个数
 * 依据完全背包的集合划分方式和优化方法 得状态转移方程为 dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - list.get(i - 1)] + 1);
 * 3、注意初始值，以dp[1][2]为例分析得dp[0][j|j>0] = MAX_VAL, dp[0][0]=0
 */
public class lc279 {
    public int numSquares(int n) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (i * i > n) break;
            list.add(i * i);
        }
        int len = list.size();
        int[][] dp = new int[len + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            dp[0][i] = Integer.MAX_VALUE;
        }
        dp[0][0] = 0;
        for (int i = 1; i <= len; i++) {
            for (int j = 1; j <= n; j++) {
                if (j - list.get(i - 1) >= 0) {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - list.get(i - 1)] + 1);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[len][n];
    }
}
