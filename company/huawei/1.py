# 1、给定一个只包含大小写字母的字符串（大小写敏感），若相邻两个元素相等则消除，直到最后字符串消除不了了，
# 输出消消乐后字符串的长度，若遇到非大小写字母以外的字符，则输出0。
"""
1 stack
2 -
3 -
4 11min 1 bug
"""
import collections


class Solution:
    def f1(ss):
        dq = collections.deque()
        for s in ss:
            if not (('a' <= s <= 'z') or ('A' <= s <= 'Z')):
                return 0
            if len(dq) == 0:
                dq.append(s)
            else:
                if dq[-1] == s:
                    dq.pop()
                else:
                    dq.append(s)
        return len(dq)


# 2、给定一个n*n的只包含0和1的二维矩阵，请你计算出该矩阵的最大值。
# 计算方式为将每一行的元素组成二进制数的十进制数相加，每一行元素可以进行左移右移（实质就是求出每行的最大值相加）， 比如说10001向左移一位就是00011。
"""
1 greedy 
1 
2 -
3 
4 1 0 1 1 0 
4 2 1 0 n-1 n-2 k
"""


class Solution2:
    # def f2(n, matrix):
    # def f_max(n, nums):
    #     # 找出距离最近的两个1
    #     start = 0
    #     while nums[start] != 1:
    #         start += 1
    #     last = start
    #     min_interval, min_idx = n+1, -1
    #     for i in range(1, n+1):
    #         idx = (start+i) % n
    #         if nums[idx] == 1:
    #             if (idx+n-last) % n < min_interval:
    #                 min_interval, min_idx = (idx+n-last) % n, last
    #             last = idx
    #     print(min_idx)
    #     ans = 0
    #     k = n-1
    #     for i in range(n):
    #         ans += (nums[(min_idx+i) % n] << k)
    #         k -= 1
    #     return ans


print(Solution2.f_max(5, [1, 0, 0, 1, 1]))


# 3、给定一棵树，删除某个结点（结点值唯一）及其下面的子结点
# （额，这题是我高度概括的，做的操作就类似于给你一棵叉树，你用剪刀把某个枝给剪掉去）,并把剩余结点按从小到大输出。
"""
1 dfs
2 -
3 
4 
"""


def f3(root, target):
    ans = []

    def dfs(root, target):
        if root == None or root.val == target:
            return
        ans.append(root.val)
    return sorted(ans)


class Solution:
    def maximumSum(self, nums: List[int]) -> int:
        arr = []
        ls = len(nums)

        def f(num):
            res = 0
            while num > 0:
                res += (num % 10)
                num //= 10
            return res

        for i in range(ls):
            arr.append((f(nums[i]), nums[i]))

        def s(x, y):
            if x[0] == y[0]:
                return x[1]-y[1]
            else:
                return x[0]-y[0]

        arr.sort(cmp=s)

        ans = -1
        for i in range(1, ls):
            if arr[i][0] == arr[i-1][0]:
                ans = max(ans, arr[i][1]+arr[i-1][1])
        return ans
