"""
2022年3月30日
1 dp
2 O(mn)
3 40min
"""
class Solution:
    def numDistinct(self, s: str, t: str) -> int:
        ls, lt = len(s), len(t)
        dp = [[0 for _ in range(lt + 1)] for _ in range(ls + 1)]
        # base case
        for i in range(0, ls + 1):
            dp[i][0] = 1
        for i in range(1, ls + 1):
            for j in range(1, lt + 1):
                dp[i][j] = dp[i - 1][j]
                if s[i - 1] == t[j - 1]:
                    dp[i][j] += dp[i - 1][j - 1]
        return dp[ls][lt]
