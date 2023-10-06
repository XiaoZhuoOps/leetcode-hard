"""
2022年3月30日
1 dp
2 mn
3 60min
"""
class Lc10:
    # 刷表法
    def isMatch(self, s: str, p: str) -> bool:
        ls, lp = len(s), len(p)
        dp = [[False for _ in range(lp+1)] for _ in range(ls+1)]
        # base case
        dp[0][0] = True
        for i in range(0, ls+1):
            for j in range(0, lp+1):
                if dp[i][j]:
                    if i+1 <= ls and j+1 <= lp and p[j] == '.':
                        dp[i+1][j+1] |= True
                    elif j+1 <= lp and p[j] == '*':
                        dp[i][j+1] |= True
                        # *可以匹配多个
                        k = i+1
                        while k <= ls and (p[j-1] == '.' or p[j-1] == s[k-1]):
                            dp[k][j+1] |= True
                            k += 1
                    elif i+1 <= ls and j+1 <= lp and p[j] == s[i]:
                        dp[i+1][j+1] |= True
                    if j+2 <= lp and p[j+1] == '*':
                        dp[i][j+2] |= True
        return dp[ls][lp]