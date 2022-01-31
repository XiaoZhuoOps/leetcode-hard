package algo.dp;

/**
 * 状态:第n天、持有或是不持有c
 * 选择：buy、sell、reset + 状态机
 * dp[n][c]:第n天、持有或是不持有c时的最大利润
 * dp[n][c][k]:第n天、持有或是不持有c时、交易了k次的最大利润={收入-支出}
 * 转移方程：
 * base：dp[0][1] = 0 dp[0][0] = 0;
 */

// k=1
public class Stock {
    public static int maxProfit(int[] prices){
        int len = prices.length;
        if(len == 0) return 0;
        int[][] dp = new int[len][2];
        //base
        dp[0][1] = -prices[0];
        dp[0][0] = 0;
        //状态
        for(int n = 1; n < len; n++){
            //转移方程
            dp[n][0] = Math.max(dp[n-1][0], dp[n-1][1]+prices[n]);
            dp[n][1] = Math.max(dp[n-1][1], -prices[n]);
        }
        return dp[len-1][0];
    }

    // k=1 优化降维
    public static int maxProfit1D(int[] prices) {
        int len = prices.length;
        if (len == 0) return 0;
        int[] dp = new int[2];
        //base
        dp[1] = -prices[0];
        //状态
        for (int n = 1; n < len; n++) {
            //转移方程
            dp[0] = Math.max(dp[0], dp[1] + prices[n]);
            dp[1] = Math.max(dp[1], -prices[n]);
        }
        return dp[0];
    }


    //k=infinte
    public static int maxProfitInfinte(int[] prices){
        int len = prices.length;
        if(len == 0) return 0;
        int[][] dp = new int[len][2];
        //base
        dp[0][1] = -prices[0];
        dp[0][0] = 0;
        //状态
        for(int n = 1; n < len; n++){
            //转移方程
            dp[n][0] = Math.max(dp[n-1][0], dp[n-1][1]+prices[n]);
            dp[n][1] = Math.max(dp[n-1][1], dp[n-1][0]-prices[n]);
        }
        return dp[len-1][0];
    }

    //k=Integer
    /**
     * 买入算为一笔交易
     * dp[n][0][k] = Math.max(dp[n-1][0][k],dp[n-1][1][k]+prices[n]);
     * dp[n][1][k] = Math.max(dp[n-1][1][k],dp[n-1][0][k-1]-prices[n]);
     *
     * 卖出才算为一笔交易
     * dp[n][0][k] = Math.max(dp[n-1][0][k],dp[n-1][1][k-1]+prices[n]);
     * dp[n][1][k] = Math.max(dp[n-1][1][k],dp[n-1][0][k]-prices[n]);
     * @param prices
     * @return
     */
    public static int maxProfitInteger(int k, int[] prices){
        int len = prices.length;
        if(len == 0) return 0;
        int[][] dp = new int[2][k+1];
        //base n=0;i=0;
        //状态
        dp[0][0] = 0;
        dp[1][0] = -prices[0];
/*
        dp[0][1] = Integer.MIN_VALUE;
        dp[1][1] = Integer.MIN_VALUE;
        */

        for(int n = 0; n < len; n++){
            for(int i = 1; i <= k; i++){
                dp[1][i] = Math.max(dp[1][i],dp[0][i]-prices[n]); // dp[1][1][1] = 101
                dp[0][i] = Math.max(dp[0][i],dp[1][i-1]+prices[n]); // dp[1][0][1] = -p[0]+p[1]
            }
        }
        //返回最大可交易次数对应的
        return dp[0][k];

    }

    //框架
    public static int maxProfitFrameWork(int k, int[] prices) {
        int len = prices.length;
        if(len == 0) return 0;
        int[][][] dp = new int[len][k+1][2];
        dp[0][0][1] = -prices[0];
        for(int i = 0; i < len; i++){
            for(int j = 0; j <= k; j++){
                if(i == 0){
                    dp[0][j][0] = 0;
                    dp[0][j][1] = -prices[0];
                    continue;
                }
                if(j == 0){
                    dp[i][0][0] = 0;
                    /*dp[i][0][1] = max(i,prices);*/
                    int min = Integer.MAX_VALUE;
                    for (int n = 0; n <= i; n++) {
                        if(prices[n] < min) min = prices[n];
                    }
                    dp[i][0][1] = -1*min;
                    continue;
                }
                dp[i][j][0] = Math.max(dp[i-1][j][0], dp[i-1][j-1][1]+prices[i]);
                //dp110 = max(dp010,dp001+p[1])?
                //dp001:第一天不允许交易手里持有
                dp[i][j][1] = Math.max(dp[i-1][j][1], dp[i-1][j][0]-prices[i]);
                /*
                第一天最多交易100次和最多交易1次结果是一样的
                dp[0][j][0] = Math.max(dp[-1][j][0], dp[-1][j-1][1]+prices[i]) = 0
                dp[0][j][1] = Math.max(dp[-1][j][1], dp[-1][j][0]-prices[i]) = -p[0]

                dp[1][j][0] = Math.max(dp[0][j][0] = 0, dp[0][j-1][1]+prices[1] = -p[0]+p[1]) = Math.max(0,p[1]-p[0])
                    dp[1][1][0] = Math.max(dp[0][1][0] = 0, dp[0][0][1]+prices[1]) = 0;
                    dp[0][0][1] = Integer.MIN 不允许交易
                dp[1][j][1] = Math.max(dp[0][j][1], dp[0][j][0]-prices[1]);

                dp[2][1][0] = Math.max(dp[1][1][0], dp[1][0][1]+prices[i])
                dp[2][1][1] = Math.max(dp[1][1][1], dp[1][1][0]+prices[i])
                */
            }
        }
        for(int i = 0; i < len; i++){
            for(int j = 0; j <= k; j++){
                System.out.printf("%d-%d-%d-%d;%d-%d-%d-%d%n",i,j,0,dp[i][j][0],i,j,1,dp[i][j][1]);
            }
        }
        return dp[len-1][k][0];
    }

    private static int max(int num,int[] prices) {
        //找出0-i天内的prices的最小值
        /*int[] ints = Arrays.copyOf(prices, num + 1);
        basic.ds.List<int[]> ints1 = Arrays.asList(ints);
        return ints1.*/
        int res = Integer.MAX_VALUE;
        for (int i = 0; i <= num; i++) {
            if(prices[i] < res) res = prices[i];
        }
        return -1*res;
    }

    //code
    public static long maxProfit(int k, int[] prices) {
        int len = prices.length;
        if(len == 0) return 0;
        long [][] dp = new long[k+1][2];
        dp[1][0] = 0;
        dp[1][1] = -prices[0];
        for(int i = 0; i < len; i++){
            for(int j = 1; j <= k; j++){
                dp[j][1] = Math.max(dp[j][1], dp[j][0]-prices[i]);
                dp[j][0] = Math.max(dp[j][0], dp[j-1][1]+prices[i]);
            }
        }
        return dp[k][0];
    }

    public static void main(String[] args) {
    }
}
