# 2022/5/24
# Trie
# 10*logN
# 
# 
class Solution:
    # [1,n]
    def findKthNumber(self, n: int, k: int) -> int:
        def getSub(i, n):
            l, r, ans = i, i, 1
            while True:
                l *= 10
                r = 10*r+9
                for i in range(l, r+1):
                    ans += 1
                    if i >= n:
                        return ans
            return -1
        
        i, j = 1, 1
        while j < k:
            sub = getSub(i, n)
            if k < j+sub:
                i *= 10
                j += 1
            else:
                i += 1
                j += sub
        return i
