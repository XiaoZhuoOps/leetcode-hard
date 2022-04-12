class Solution:
    """
    2022年4月11日
    1 并查集
    2 O(n^2)
    3
    4
    """
    def findRedundantDirectedConnection(self, edges: List[List[int]]) -> List[int]:
        n = len(edges)
        par = [0 for _ in range(n + 1)]
        conflict = -1
        circle = -1
        for i in range(1, n + 1):
            par[i] = i

        def getRoot(a):
            nonlocal par
            while par[a] != a:
                a = par[a]
            return a

        for i in range(len(edges)):
            a, b = edges[i][0], edges[i][1]  # a->b
            if par[b] != b:
                conflict = i
            elif getRoot(a) == getRoot(b):
                circle = i
            else:
                par[b] = a
        if conflict < 0:
            return edges[circle]
        elif circle != -1:
            return [par[edges[conflict][1]], edges[conflict][1]]
        else:
            return edges[conflict]
