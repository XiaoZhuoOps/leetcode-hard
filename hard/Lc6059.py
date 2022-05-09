class Solution:
    def hasValidPath(self, grid: List[List[str]]) -> bool:
        m, n = len(grid), len(grid[0])
        @cache
        def dfs(x, y, c):
            if x == m-1 and y == n-1:
                return c == 0
            if grid[x][y] == '(':
                c += 1
            else:
                c -= 1
            if c < 0:
                return False
            return (x+1 < m and dfs(x+1, y, c)) or (y+1 < n and dfs(x, y+1, c))
        return dfs(0,0,0)