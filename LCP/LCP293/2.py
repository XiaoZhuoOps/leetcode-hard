class Solution:
    def maxConsecutive(self, bottom: int, top: int, s: List[int]) -> int:
        s = [bottom-1]+sorted(s)+[top+1]
        ans = -1
        for i in range(1,len(s)):
            ans = max(ans, s[i]-s[i-1]-1)
        return ans