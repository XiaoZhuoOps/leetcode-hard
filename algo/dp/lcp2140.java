package algo.dp;

import java.util.Arrays;

public class lcp2140 {
}
/**
 * 1、正向dp；采用刷表法，每次更新当前状态的选择对其他状态的影响
 * 2、dp[i] 从[0,i)范围内能获得的最大点数
 *      若选当前的问题，则更新后续第i+questions[i][1]+1个状态；
 *      若不选当前问题，则更新第i+1个状态
 *    最终返回dp[n]
 *    时间复杂度 O(n)
 * 3、先写DP伪代码/框架，考虑base及j>len的情况
 */
class Solution {
    public long mostPoints(int[][] questions) {
        int len = questions.length;
        long[] dp = new long[len+1];
        dp[0] = 0;
        for (int i = 0; i < len; i++) {
            dp[i+1] = Math.max(dp[i+1], dp[i]); //不选
            int j = i + questions[i][1] + 1;
            if (j > len) j = len;
            dp[j] = Math.max(dp[j], dp[i]+questions[i][0]); //选
        }
        return dp[len];
    }
}
/**
 * 1、递归/反向dp；
 * 2、可以把所有的选择看作是一棵树，dfs(i) = max(dfs(i+1), dfs(j)+q[i][1])
 *    base: dfs(k)=q[len-1][1] k+1>=len
 *    end: dfs(0)
 * 3、先写递归框架，考虑base case，返回dfs(0)
 * 4、超时，采用记忆化递归，用dp记录
 */
class Solution2 {
    int[][] questions;
    long[] dp;
    public long mostPoints(int[][] questions) {
        this.questions = questions;
        this.dp = new long[questions.length];
        Arrays.fill(dp, -1);
        return dfs(0);
    }

    long dfs(int i) {
        if (i >= questions.length) return 0;
        if (dp[i] != -1) return dp[i];
        int j = i + questions[i][1] + 1;
        long res = Math.max(dfs(i+1), dfs(j)+questions[i][0]);
        dp[i] = res;
        return res;
    }
}
