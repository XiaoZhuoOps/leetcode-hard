"""
2022年4月8日

"""
class Node:
    def __init__(self):
        self.chs = {} # 'a' -> Node()
        self.word = "" #以当前字符结尾的单词

class Trie:
    def __init__(self):
        self.root = Node() #冗余节点

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
        dirs = [[1, 0], [-1, 0], [0, 1], [0, -1]]
        ans = []
        trie = Trie()
        for word in words:
            trie.add(word)

        # 此处的node是进入节点前的父node
        def dfs(i, j, board, node):
            if i < 0 or i >= m or j < 0 or j >= n:
                return
            ch = board[i][j]
            if ch == "#":
                return
            if ch not in node.chs:
                return
            node = node.chs[ch]
            if node.word != "":
                ans.append(node.word)
            # path用“#”替代
            board[i][j] = "#"
            for dir in dirs:
                dfs(i + dir[0], j + dir[1], board, node)
            # path用“#”还原
            board[i][j] = ch

        for i in range(m):
            for j in range(n):
                dfs(i, j, board, trie.root)
        return list(set(ans))
