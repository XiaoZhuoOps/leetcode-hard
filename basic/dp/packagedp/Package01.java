package basic.dp.packagedp;


public class Package01 {
    /**
     * 01背包
     */
    public int package01(int[] vs, int[] ws, int c) {
        int len = vs.length;
        int[][] dp = new int[len + 1][c + 1];
        for (int i = 1; i <= len; i++) {
            for (int j = 1; j <= c; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j - vs[i - 1] >= 0) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - vs[i - 1]] + ws[i - 1]);
                }
            }
        }
        return dp[len + 1][c + 1];
    }
    /**
     * 优化
     * 状态压缩，转移方程只用到了i和i-1，可以去掉这一维度
     */
    public int package01_2(int[] vs, int[] ws, int c) {
        int len = vs.length;
        int[] dp = new int[c + 1];
        for (int i = 1; i <= len; i++) {
            for (int j = c; j >= vs[i - 1]; j--) {
                dp[j] = Math.max(dp[j], dp[j - vs[i - 1]] + ws[i - 1]);
            }
        }
        return dp[c + 1];
    }
}
