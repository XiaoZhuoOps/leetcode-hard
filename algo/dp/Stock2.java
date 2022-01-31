package algo.dp;

public class Stock2 {
    /**
     *
     * @param k
     * @param prices
     * @return
     */
    public int maxProfit(int k, int[] prices) {
        int len = prices.length;
        if(len == 0) return 0;
        int[][][] dp = new int[len][k+1][2];

        for(int i = 0; i < len; i++){
            for(int j = 0; j <= k; j++){
                if(i == 0){
                    dp[0][j][0] = 0;
                    dp[0][j][1] = -prices[0];
                    continue;
                }
                if(j == 0){
                    dp[i][0][0] = 0;
                    int min = Integer.MAX_VALUE;
                    for (int n = 0; n <= i; n++) {
                        if(prices[n] < min) min = prices[n];
                    }
                    dp[i][0][1] = -1*min;
                    continue;
                }
                dp[i][j][0] = Math.max(dp[i-1][j][0], dp[i-1][j-1][1]+prices[i]);
                dp[i][j][1] = Math.max(dp[i-1][j][1], dp[i-1][j][0]-prices[i]);
            }
        }
        return dp[len-1][k][0];
    }

    public int maxProfit2d(int k, int[] prices) {
        int len = prices.length;
        if(len == 0) return 0;
        int[][] dp = new int[k+1][2];

        for(int j = 0; j <= k; j++){
            dp[j][0] = 0;
            dp[j][1] = -prices[0];
        }
        for(int i = 1; i < len; i++){
            int min = Integer.MAX_VALUE;
            for (int n = 0; n <= i; n++) {
                if(prices[n] < min) min = prices[n];
            }
            dp[0][1] = -1*min;
            dp[0][0] = 0;
            for(int j = 1; j <= k; j++){
                dp[j][1] = Math.max(dp[j][1], dp[j][0]-prices[i]);
                dp[j][0] = Math.max(dp[j][0], dp[j-1][1]+prices[i]);
                System.out.printf("%d-%d-%d-%d;%d-%d-%d-%d%n",i,j,0,dp[j][0],i,j,1,dp[j][1]);
            }
        }
        return dp[k][0];
    }

    public static void main(String[] args) {
        int[] stock3 = {3,2,6,5,0,3};
        int res = new Stock2().maxProfit2d(2, stock3);
        System.out.println(res);

    }
}
