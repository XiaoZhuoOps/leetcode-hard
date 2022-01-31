package algo.dp;

public class lc629 {
    public int kInversePairs(int n, int k) {
        int[][] dp = new int[2][1001];
        //n = 1时的边界
        dp[1][0] = 1;
        int cur = 0, last = 0, mod = 1000000007;

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j <= k; j++) {
                cur = i & 1; //按奇偶确定行号
                last = cur ^ 1; //取反
                dp[cur][j] = dp[last][j] + (j >= 1 ? dp[cur][j - 1] : 0) - (j >= i ? dp[last][j - i] : 0);
                //取mod
                if(dp[cur][j] > mod) {
                    dp[cur][j] = dp[cur][j] - mod;
                } else if (dp[cur][j] < 0){
                    dp[cur][j] = dp[cur][j] + mod;
                }
            }
        }
        return dp[n & 1][k];
    }
}
