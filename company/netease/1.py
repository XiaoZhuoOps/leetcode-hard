"""
1 dfs
2 i vis cnt 
3 
4
"""
# class Solution:
#     def f(boxes):
#         n = len(boxes)
#         vis, cnt = [False for _ in range(n)], n-1

#         def dfs(i):
#             nonlocal vis, cnt
#             if vis[i]:
#                 return
#             vis[i] = True
#             cnt -= 1
#             for next in boxes[i]:
#                 dfs(next)
#         dfs(0)
#         print(cnt == 0)


# line = input().strip('[]').split()
# print(line)
# n = len(line)
# boxes = [[] for _ in range(n)]
# # for arr in line:
"""
1 
2 i vis cnt 
3 
4
"""
s = input()
n = len(s)-2
s = int(s)
ans = 0
for i


print(ans)
"""
1 
2 
3 
4
"""


class Solution:
    def solution(self, n: int, x1: int, y1: int, x2: int, y2: int) -> int:
        # write code here
