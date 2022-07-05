"""
2022年4月1日
1 树形dp
2 dp[0][0] = min(l[0][1]+r[0][1], l[0][0]+r[0][1], l[0][1]+r[0][0])
2 dp[0][1] = min(l[1][1]+r[1][1], l[1][0]+r[1][1], l[1][1]+r[1][0], r[1][0]+l[1][0])+1
2 dp[1][0] = min(dp[0][0], l[0][0] + r[0][0])
2 dp[1][1] = dp[0][1]
3
"""


class Solution:
    def minCameraCover(self, root: TreeNode) -> int:
        # dp = [[0 for _ in range(2)] for _ in range(2)]

        def dfs(root):
            dp = [[0 for _ in range(2)] for _ in range(2)]
            if root == None:
                dp[0][0] = 0
                dp[0][1] = 10000
                dp[1][0] = 0
                dp[1][1] = 10000
                return dp
            if root.left == None and root.right == None:
                dp[0][0] = 10000
                dp[0][1] = 1
                dp[1][0] = 0
                dp[1][1] = 1
                return dp
            l = dfs(root.left)
            r = dfs(root.right)

            dp[0][0] = min(l[0][1] + r[0][1], l[0][0] + r[0][1], l[0][1] + r[0][0])
            dp[0][1] = min(l[1][1] + r[1][1], l[1][0] + r[1][1], l[1][1] + r[1][0], r[1][0] + l[1][0]) + 1
            dp[1][0] = min(dp[0][0], l[0][0] + r[0][0])
            dp[1][1] = dp[0][1]
            return dp

        dp = dfs(root)
        return min(dp[0][1], dp[0][0])