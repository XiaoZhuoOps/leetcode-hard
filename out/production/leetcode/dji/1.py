"""
CD00P000
i j
"""


class Solution:
    def f(s, m):
        n = len(s)
        i, j = 0, 0
        while j < n and s[j] != '0':
            j += 1
        if j == n:
            return s
        i = j
        while j < n:
            if s[j] != '0':
                s[i], s[j] = s[j], s[i]
                i += 1
            j += 1
        return s[:n-m]


s = input()
m = int(input())
print(Solution.f(s, m))
