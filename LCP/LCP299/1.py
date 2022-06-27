class DSU:
    def __init__(self, N):
        self.root = [i for i in range(N)]

    def find(self, k):
        if self.root[k] == k:
            return k
        return self.find(self.root[k])

    def union(self, a, b):
        x = self.find(a)
        y = self.find(b)
        if x != y:
            self.root[y] = x
        return

    def connected(self, a, b):
        return self.find(self, a) == self.find(self, b)


class Solution:
    def minimumScore(self, vals: List[int], edges: List[List[int]]) -> int:
        n = len(vals)
        uf = DSU(n)
        for e in edges:
            v1, v2 = e[0], e[1]
            if uf.root[v1] != v1:
                v1, v2 = v2, v1
            uf.root[v1] = v2

        ans
        for i in range(n-1):
            e1 = edges[i]
            for j in range(i+1, n-1):
                e2 = edges[j]
