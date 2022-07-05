class Solution:
    def appealSum(self, s: str) -> int:
        ls, sum = len(s), 0
        map = [-1 for _ in range(26)]
        for i in range(ls-1, -1, -1):
            map[ord(s[i])-ord('a')] = i
            for ch in range(26):
                if map[ch] != -1:
                    sum += (ls-map[ch])
        return sum