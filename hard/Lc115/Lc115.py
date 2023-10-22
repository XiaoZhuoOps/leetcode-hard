"""
2022年3月30日
1 dp
2 O(mn)
3 40min
"""
class Solution:
    def numDistinct(self, s: str, t: str) -> int:
        ls, lt = len(s), len(t)
        # 下标1->N，开1+N个空间
        dp = [[0 for _ in range(lt + 1)] for _ in range(ls + 1)]
        # base case
        # dp[0][j] = 0
        # 以dp[1][1] = dp[0][1] + dp[0][0]， dp[7][1] = dp[6][1] + dp[6][0]为例
        for i in range(0, ls + 1): 
            dp[i][0] = 1
        for i in range(1, ls + 1): # 1->ls+1
            for j in range(1, lt + 1): # 1->lt+1
                # 依据[是否包含最后一个元素]划分为2类集合，[求和]
                dp[i][j] = dp[i - 1][j] + (dp[i - 1][j - 1] if s[i - 1] == t[j - 1] else 0)            
        return dp[ls][lt]

    # 空间优化版本
    def numDistinct2(self, s: str, t: str) -> int:
        ls, lt = len(s), len(t)
        f = [0]*(lt+1)
        f[0] = 1
        for i in range(ls):
            for j in range(lt, -1, -1):
                f[j] += (f[j-1] if s[i] == t[j] else 0)
        return f[lt]