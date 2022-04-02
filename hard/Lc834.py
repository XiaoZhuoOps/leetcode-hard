"""
2022年4月1日
1 树形dp/递归
2 down[p] = sum(down[s]+ch[s]) up[s] = up[p]+n-ch[p]+1+down[p]-down[s]-ch[u]+ch[p]-ch[s]-1 = up[p]+n+down[p]-down[s]-ch[s]-ch[s]
3 60min
"""
class Solution:
    def sumOfDistancesInTree(self, n: int, edges: List[List[int]]) -> List[int]:
        up, down, ch, ans = [0 for _ in range(n)], [0 for _ in range(n)], [0 for _ in range(n)], [0 for _ in range(n)]

        # build graph
        graph = [[] for _ in range(n)]
        for edge in edges:
            graph[edge[0]].append(edge[1])
            graph[edge[1]].append(edge[0])

        def dfsDown(graph, visited, cur, par):
            visited[cur] = True
            ch[cur] = 1
            for s in graph[cur]:
                if visited[s]:
                    continue
                dfsDown(graph, visited, s, cur)
                ch[cur] += ch[s]
                down[cur] += down[s] + ch[s]

        def dfsUp(graph, visited, cur, par):
            # up[s] = up[p]+n+down[p]-down[s]-ch[s]-ch[s]
            if par == -1:
                up[cur] = 0
            else:
                up[cur] = up[par] + n + down[par] - down[cur] - 2*ch[cur]
            visited[cur] = True
            for s in graph[cur]:
                if visited[s]:
                    continue
                dfsUp(graph, visited, s, cur)

        dfsDown(graph, [False for _ in range(n)], 0, -1)
        dfsUp(graph, [False for _ in range(n)], 0, -1)

        for i in range(n):
            ans[i] = up[i]+down[i]
        return ans