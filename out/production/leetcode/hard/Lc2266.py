class Solution:
    def countTexts(self, p: str) -> int:
        mod = 10**9 + 7
        f = [1,1,2,4]
        g = [1,1,2,4]
        for i in range(10**5):
            f.append(f[-1]+f[-2]+f[-3])
            g.append(g[-1]+g[-2]+g[-3]+g[-4])

        ls = len(p)
        i = 0
        while i < ls:
            j = i
            while j < ls:
                if p[j] != p[i]:
                    ans *= (f[j-i] if p[i] in "79" else g[j-i])%mod
                    i = j
                    break
                j += 1
            if j == ls:
                dp = {}
                ans *= (f[j-i] if p[i] in "79" else g[j-i])%mod
                break
        return int(ans % mod)