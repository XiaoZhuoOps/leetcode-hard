# 分组dp
# 
# 
class Solution:
    def maxValueOfCoins(self, piles: List[List[int]], k: int) -> int:
        wvs = []
        for pile in piles:
            ps = 0
            wv = []
            for i in range(pile):
                ps += pile[i]
                wv.append([i+1, ps])
            wvs.append(wv)

        ls = len(piles)
        dp = [0]*(k+1)
        for i in range(0,ls):
            for j in range(k,0,-1):
                for wv in wvs[i]:
                    if 0 <= j-wv[0]:
                        dp[j] = max(dp[j], dp[j-wv[0]]+wv[1])
        return dp[k]

# 灵神版本
class Solution:
    def maxValueOfCoins(self, piles: List[List[int]], k: int) -> int:
        f = [0] * (k + 1)
        sum_n = 0
        for pile in piles:
            n = len(pile)
            for i in range(1, n):
                pile[i] += pile[i - 1]  # pile 前缀和
            sum_n = min(sum_n + n, k)  # 优化：j 从前 i 个栈的大小之和开始枚举（不超过 k）
            for j in range(sum_n, 0, -1):
                f[j] = max(f[j], max(f[j - w - 1] + pile[w] for w in range(min(n, j))))  # w 从 0 开始，物品体积为 w+1
        return f[k]