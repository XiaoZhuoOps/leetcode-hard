class Solution:
    def countTexts(self, pressedKeys: str) -> int:
        mod = 1e9 + 7
        ans = 1
        def f(s):
            if s == '7' or s == '9':
                return 4
            return 3

        dp = {}
        def g(a, b):
            nonlocal dp
            if a in dp:
                return dp[a]
            res = 0
            if a == 0:
                return 1
            for i in range(1, b+1):
                if a-i >= 0:
                    res += (g(a-i, b)%mod)
            dp[a] = res
            return res

        ls = len(pressedKeys)
        i = 0
        while i < ls:
            j = i
            while j < ls:
                if pressedKeys[j] != pressedKeys[i]:
                    dp = {}
                    ans *= g(j-i, f(pressedKeys[i]))%mod
                    i = j
                    break
                j += 1
            if j == ls:
                dp = {}
                ans *= g(j-i, f(pressedKeys[i]))%mod
                break
        return int(ans % mod)