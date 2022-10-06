"""
1 
2
3
4
"""
# class Solution:
#     def f(n, t, nums):
#         nums.sort(reverse=True)
#         ct = 0
#         ans = 0
#         while nums:
#             if nums[-1] < ct + t:
#                 ans += 1
#             else:
#                 ct += t
#             nums.pop(-1)
#         return ans


# line = list(map(int, input().split()))
# n, t = line[0], line[1]
# nums = list(map(int, input().split()))
# print(Solution.f(n, t, nums))
"""
1 
2
3
4
"""
# class Solution:
#     def f(n, m, k, move):
#         vis = [[False for _ in range(m)] for _ in range(n)]
#         vis[0][0] = True
#         cnt = n*m-1
#         x, y = 0, 0
#         for i in range(k):
#             if move[i] == 'W':
#                 x, y = x-1, y
#             if move[i] == 'A':
#                 x, y = x, y-1
#             if move[i] == 'S':
#                 x, y = x+1, y
#             if move[i] == 'D':
#                 x, y = x, y+1
#             if not vis[x][y]:
#                 cnt -= 1
#             vis[x][y] = True
#             if cnt == 0:
#                 print("Yes")
#                 print(i+1)
#                 return
#         print("No")
#         print(cnt)


# line = list(map(int, input().split()))
# n, m, k = line[0], line[1], line[2]
# move = str(input())
# Solution.f(n, m, k, move)
"""
1 moni
2 
3
4
"""
# import collections
# class Solution:
#     def f(n, ps):
#         # s = [ps[-1]]
#         dq = collections.deque()
#         dq.append(ps[-1])
#         for i in range(n-2, -1, -1):
#             # s = [ps[i]] + s
#             # s.insert(0, ps[i])
#             dq.appendleft(ps[i])
#             # s = s[-2:] + s[:-2]
#             dq.appendleft(dq.pop())
#             dq.appendleft(dq.pop())
#         print(" ".join(list(map(str, dq))))


# n = int(input())
# ps = list(map(int, input().split()))
# Solution.f(n, ps)
"""
1 a[i]+a[k]=3a[j]
2 
3
4
"""
# import bisect
# class Solution:
#     def f(nums):
#         n = len(nums)
#         ans = 0
#         for j in range(1, n-1):
#             tmp = sorted(nums[j+1:])
#             for i in range(j):
#                 t = 3*nums[j]-nums[i]
#                 idx = bisect.bisect_left(tmp, t)
#                 if 0 <= idx < len(tmp) and tmp[idx] == t:
#                     ans += (bisect.bisect_right(tmp, t)-idx)
#         print(ans)
# n = int(input())
# nums = list(map(int, input().split()))
# Solution.f(nums)
"""
1 
2 
3
4
"""


class Solution:
    def f(n, ms):
        def dfs(idx):
            nonlocal n, ms
            res = ms[idx-1]
            lch, rch = 0, 0
            if 2*idx <= n:
                lch = dfs(2*idx)
            if 2*idx+1 <= n:
                rch = dfs(2*idx+1)
            return res+max(lch, rch)
        print(dfs(1))


n = int(input())
ms = list(map(int, input().split()))
Solution.f(n, ms)
