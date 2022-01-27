package basic.dp.lis;
/**
 * 最长公共子序列
 */
public class Lcis {
    int lcis(int[] as, int[] bs) {
        int n = as.length, m = bs.length;
        int[][] f = new int[n+1][m+1];
        //dp[0][0] = 0
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                f[i][j] = Math.max(f[i-1][j], f[i][j-1]);
                if (as[i] == bs[j]) f[i][j] = Math.max(f[i][j], f[i-1][j-1]+1);
            }
        }
        return f[n][m];
    }
}
