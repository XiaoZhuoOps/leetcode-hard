"""
s->[0,1<<(n+1)-1] and s&(1<<i)==1
i->[0,n-1]
dp[s,i] = dp[s^(1<<i),j]+w[i,j] if (s>>j)&1 == 1
dp[1<<(n+1)-1, n-1]
"""


class solution:
    def shortest_hamilton(w, n):
        dp = [[float('inf') for _ in range(n)] for _ in range(1 << (n+1))]

        for i in range(n):
            for s in range(0, 1 << (n+1)):
                if s & (1 << i) != 1:
                    continue
                for j in range(n):
                    if (s >> j) & 1 != 1:
                        continue
                    dp[s][i] = min(dp[s][i], dp[s ^ (1 << i)][j]+w[i][j])
        return dp[1 << (n+1)-1][n-1]
