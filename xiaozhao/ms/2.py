"""
1 greedy
2 -
3
4
"""


def solution(A):
    # write your code in Python (Python 3.6)
    h = []
    ans, r, s = 0, 0, sum(A)
    for p in A:
        heapq.heappush(h, -1*p)
    while r < s/2:
        p = -1*heapq.heappop(h)
        p = p/2
        r += p
        ans += 1
        heapq.heappush(h, -1*p)
    return ans


"""
1 sort
1 dfs(i)=sum
2 
3 
4 
"""


def solution(X, Y):
    # write your code in Python (Python 3.6)
    def dfs(X, Y, idx, s):
        return 0


"""
1
2 dp[i][x] = dp[i+y][x-1]+A[i]
2 dp[i][x] -> dp[i-y][x+1] + A[i-Y]
3 dp[i][1] = A[i]
4 
"""


def solution(A, X, Y):
    # write your code in Python (Python 3.6)
    n = len(A)
    dp = [[float('-inf') for _ in range(X+1)] for _ in range(n)]

    for i in range(n):
        dp[i][1] = A[i]
    for i in range(n-1, -1, -1):
        for x in range(1, X):
            if 0 <= i-Y and x+1 <= X:
                dp[i-Y][x+1] = dp[i][x] + A[i-Y]

    min_cost = float('inf')
    i = 0
    while i+(X-1)*Y < n:
        min_cost = min(min_cost, dp[i][X])
        i += 1
    return min_cost
