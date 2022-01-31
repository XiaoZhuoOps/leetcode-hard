package algo.dp;

public class lc1143 {
    public int longestCommonSubsequence(String text1, String text2) {
        char[] as = text1.toCharArray(), bs = text2.toCharArray();
        int n = as.length, m = bs.length;
        int[][] f = new int[n+1][m+1];
        //dp[0][0] = 0
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                f[i][j] = Math.max(f[i-1][j], f[i][j-1]);
                if (as[i-1] == bs[j-1]) f[i][j] = Math.max(f[i][j], f[i-1][j-1]+1);
            }
        }
        return f[n][m];
    }
}
