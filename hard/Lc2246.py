class Solution:
    def longestPath(self, ps: List[int], s: str) -> int:
        n = len(s)
        chs = [[] for _ in range(n)]
        for i in range(1,n):
            chs[ps[i]].append(i)

        ans = 1
        def f(i):
            if i == -1:
                return 0, 0
            # lch, rch = chs[i][0], chs[i][1]
            # lres, rres = f(lch), f(rch)
            # lmax = max(lres[0], lres[1])+1 if lch != -1 and s[i] != s[lch] else 1
            # rmax = max(rres[0], rres[1])+1 if rch != -1 and s[i] != s[rch] else 1
            # ans = max(ans, lmax+rmax-1)
            return lmax, rmax
        return f(0)