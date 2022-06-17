# 
# 
#
# [-1,0,1]
# "aab"
class Solution:
    def longestPath(self, ps: List[int], s: str) -> int:
        n = len(s)
        chs = [[] for _ in range(n)]
        for i in range(1,n):
            chs[ps[i]].append(i)

        ans = 0
        def g(a, b, l):
            if l > a:
                b, a = a, l
            elif l > b:
                b = l
            return a, b

        def f(i):
            nonlocal ans
            a, b = 1, 1
            for ch in chs[i]:
                l = f(ch)
                a, b = g(a, b, 1 if s[ch] == s[i] else l+1)
                ans = max(ans, a+b-1)
            return a
        f(0)
        return ans
