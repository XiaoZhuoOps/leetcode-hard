class Solution:
    # [1,n]
    def findKthNumber(self, n: int, k: int) -> int:
        def getSub(a, n):
            a, b = str(x), str(limit)
            k = len(b) - len(a)
            ans = sum(10 ** i for i in range(k)) if k else 0
            ans += 10 ** k if (u := int(b[:len(a)])) > x else limit - x * 10 ** k + 1 if u == x else 0
            return ans
        i, j = 0, 0
        while True:
            for _ in range(10):
                sub = getSub(i+1, n)
                if j+sub > k:
                    i *= 10
                    i += 1
                    break
                elif j+sub == k:
                    if sub == 1:
                        return i+1
                    else:
                        i *= 10
                        i += 1
                        break
                else:
                    i += 1
                    j += sub
        return -1
