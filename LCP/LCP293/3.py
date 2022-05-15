class Solution:
    def largestCombination(self, cs: List[int]) -> int:
        ans = -1
        for i in range(32):
            num = 0
            for c in cs:
                if c&(1<<i) != 0:
                    num += 1
            ans = max(ans, num)
        return ans