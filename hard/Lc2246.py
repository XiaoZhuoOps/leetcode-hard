class Solution:
    def longestPath(self, ps: List[int], s: str) -> int:
        n = len(s)
        chs = [[] for _ in range(n)]
        for i in range(1,n):
            chs[ps[i]].append(i)

        ans = 1
        def g(a, b, l):
            if a < l:
                b, a = a, l
            elif b < l:
                b = l
            return a, b

        def f(i):
            nonlocal ans
            for ch in chs[i]:
                l = f(chs[i])
                a, b = g(a, b, 1 if s[ch] == sh[i] else l+1)
                ans = max(ans, a+b-1)
            return a
        f(0)
        return ans