"""
999880000
"""


# class c:
#     def solution(S) -> str:
#         # write your code in Python (Python 3.6)
#         map = [0 for _ in range(10)]
#         for ch in S:
#             map[ord(ch)-ord('0')] += 1
#         prefix = mid = ""
#         f = False
#         for i in range(9, -1, -1):
#             if map[i] >= 2:
#                 for _ in range(map[i]//2):
#                     prefix += str(i)
#                 map[i] -= 2*(map[i]//2)

#             if map[i] >= 1:
#                 if not f:
#                     mid = str(i)
#                     f = True
#         ans = (prefix+mid+prefix[::-1]).strip("0")
#         return ans if ans != "" else "0"


# print(c.solution("110"))

class c:
    def solution(A, B):
        # write your code in Python (Python 3.6)
        n = len(A)
        tree = [[] for _ in range(n+1)]
        for i in range(n):
            tree[A[i]].append(B[i])
            tree[B[i]].append(A[i])
        ans = 0

        def dfs(i, f):
            nonlocal tree, ans
            num = 1
            for ch in tree[i]:
                if ch == f:
                    continue
                num += dfs(ch, i)
            ans += (num//5 if num % 5 == 0 else (num//5)+1)
            print(num)
            return num
        dfs(0, -1)
        return ans


c.solution([0, 1, 1], [1, 2, 3])
