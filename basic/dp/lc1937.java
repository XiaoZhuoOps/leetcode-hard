package basic.dp;

public class lc1937 {
    public long maxPoints(int[][] points) {
        int m = points.length, n = points[0].length;
        long[][] dp = new long[2][n];
        long[] max1 = new long[n]; // max{dp(i-1,k)+k} k<j
        long[] max2 = new long[n]; // max{dp(i-1,k)-k} k>j

        for (int i = 0; i < n; i++) {
            dp[0][i] = points[0][i];
        }

        for (int i = 1; i < m; i++) {
            max1[0] = dp[(i-1)%2][0];
            max2[n-1] = dp[(i-1)%2][n-1]-n+1;
            for (int j = 1; j < n; j++) {
                max1[j] = Math.max(max1[j-1], dp[(i-1)%2][j]+j);
            }
            for (int j = n-2; 0 <= j; j--) {
                max2[j] = Math.max(max2[j+1], dp[(i-1)%2][j]-j);
            }
            for (int j = 0; j < n; j++) {
                dp[i%2][j] = Math.max(max1[j]-j, max2[j]+j) + points[i][j];
            }
        }
        long max = Integer.MIN_VALUE;
        for (int j = 0; j < n; j++) {
            max = Math.max(max, dp[(m-1)%2][j]);
        }
        return max;
    }
}
