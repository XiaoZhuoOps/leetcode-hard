class Solution:
    def removeAnagrams(self, words: List[str]) -> List[str]:
        i, j, ls = 0, 0, len(words)
        ans = []
        while j < ls:
            while j < ls and sorted(words[j]) == sorted(words[i]):
                j += 1
            ans.append(words[i])
            i = j
        return ans