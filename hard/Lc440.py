class Node:
    def __init__(self):
        self.num = 0
        self.size = 0
        self.chs = [None for _ in range(10)]
class Trie:
    def __init__(self):
        self.root = Node()

    def add(self, numStr):
        cur = self.root
        for w in numStr:
            cur = cur.chs[ord(w)]

        cur.word = word
    def search(self, word):
        cur = self.root
        for w in word:
            if w not in cur.chs:
                return False
            cur = cur.chs[w]
        return cur.word == ""

class Solution:
    def findKthNumber(self, n: int, k: int) -> int:
