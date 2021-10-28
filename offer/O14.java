package offer;

/**
 * step1
 *      有加法就想到子问题 dp
 * step2
 *      dp
 *          dp[n] 最大乘积
 *          dp[n] = max{dp[i]*dp[n-i],i*dp[n-i],dp[i]*n-i,i*n-i}
 *          i=2:n/2
 *          dp[2]=1
 *      O(n^2) 如何优化
 *          null
 * step3
 *      null
 */
public class O14 {
    public int cuttingRope(int n) {
        int[] dp = new int[n+1];
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            int dpi = 0;
            for (int j = 2; j <= i/2; j++) {
                int temp1 = Math.max(dp[j], j);
                int temp2 = Math.max(dp[i-j], i-j);
                if(dpi < temp1*temp2) dpi = temp1*temp2;
            }
            dp[i] = dpi;
        }
        return dp[n];
    }
}
