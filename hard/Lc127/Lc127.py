"""
2022年4月14日
1 bfs
2 
3 
"""


class Solution:
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        if endWord not in wordList:
            return 0

        def isAdj(a, b):
            n = 0
            for i in range(len(a)):
                if a[i] != b[i]:
                    if n > 0:
                        return False
                    n += 1
            return n == 1

        def bfs(s, e):
            step1, vis1 = 0, set()
            step2, vis2 = 0, set()
            vis1.add(s)
            vis2.add(e)
            q1 = collections.deque()
            q1.appendleft(s)
            q2 = collections.deque()
            q2.appendleft(e)
            while q1 or q2:
                size1 = len(q1)
                size2 = len(q2)
                if size1 > 0 and (size2 == 0 or size2 >= size1):
                    step1 += 1
                    for i in range(size1):
                        c1 = q1.pop()
                        if c1 in vis2:
                            return step1 + step2
                        for adj in wordList:
                            if (not isAdj(adj, c1)) or (adj in vis1):
                                continue
                            vis1.add(adj)
                            q1.appendleft(adj)

                if size2 > 0 and (size1 == 0 or size2 < size1):
                    step2 += 1
                    for i in range(size2):
                        c2 = q2.pop()
                        if c2 in vis1:
                            return step1 + step2
                        for adj in wordList:
                            if (not isAdj(adj, c2)) or (adj in vis2):
                                continue
                            vis2.add(adj)
                            q2.appendleft(adj)
            return 0
        return bfs(beginWord, endWord)
