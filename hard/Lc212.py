"""
2022年4月8日

"""
class Node:
    def __init__(self):
        self.chs = {}
        self.word = ""

class Trie:
    def __init__(self):
        self.root = Node()

    def add(self, word):
        cur = self.root
        for w in word:
            if w not in cur.chs:
                cur.chs[w] = Node()
            cur = cur.chs[w]
        cur.word = word

class Solution:
    def findWords(self, board: List[List[str]], words: List[str]) -> List[str]:
        m, n = len(board), len(board[0])
        ans = []
        trie = Trie()
        for word in words:
            trie.add(word)

        def dfs(i, j, board, node):
            nonlocal m, n
            if i < 0 or i >= m or j < 0 or j >= n:
                return
            ch = board[i][j]
            if ch == "#":
                return
            if ch not in node.chs:
                return
            node = node.chs[ch]
            if node.word != "" and node.word not in ans:
                ans.append(node.word)
            board[i][j] = "#"
            dirs = [[1, 0], [-1, 0], [0, 1], [0, -1]]
            for dir in dirs:
                dfs(i + dir[0], j + dir[1], board, node)
            board[i][j] = ch

        for i in range(m):
            for j in range(n):
                dfs(i, j, board, trie.root)
        return ans
