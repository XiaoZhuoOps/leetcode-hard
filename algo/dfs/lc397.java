package algo.dfs;

public class lc397 {
    public static void main(String[] args) {
        int n =
                2147483647;
        int res = new Solution().integerReplacement(n);
    }
}

class Solution {
    int[] dp;
    public int integerReplacement(int n) {
        this.dp = new int[1000];
        return dfs(n);
    }

    int dfs(int n) {
        if (n == 1) return 0;
        if (n <= 1000 && dp[n-1] != 0) return dp[n-1];
        int res = 0;
        if (n%2 == 0) {
            res = dfs(n/2) + 1;
        } else {
            res = Math.min(dfs(n+1), dfs(n-1)) + 1;
        }
        if (n <= 1000){
            dp[n - 1] = res;
        }
        return res;
    }
}
