package LCP.LCP272;

class lc5958 {
    public long getDescentPeriods(int[] prices) {
        int len = prices.length;
        long[] dp = new long[len];
        dp[0] = 1;
        for (int i = 1; i < len; i++) {
            if (prices[i] == prices[i-1]-1) {
                dp[i] = dp[i-1] + 1;
            } else dp[i] = 1;
        }
        long res = 0;
        for (int i = 0; i < len; i++) {
            res += dp[i];
        }
        return res;
    }
}
