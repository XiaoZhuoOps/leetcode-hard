package algo.dp;

public class lc221 {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m][n];
        int tmp, max = -1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                tmp = matrix[i][j];
                if (i == 0 || j == 0) dp[i][j] = (tmp == '1') ? 1 : 0;
                else {
                    if (tmp == '1') {
                        dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i-1][j-1]), dp[i][j-1]) + 1;
                    } else {
                        dp[i][j] = 0;
                    }
                }
                max = Math.max(max, dp[i][j]);
            }
        }
        return max*max;
    }
}
