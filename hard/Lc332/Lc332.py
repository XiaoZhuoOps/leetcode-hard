import heapq


class Solution:
    """
    2022年4月13日
    1 dfs
    2 O(E)
    3
    """

    def findItinerary(self, tickets: List[List[str]]) -> List[str]:
        graph = {}
        for edge in tickets:
            start, end = edge[0], edge[1]
            if start not in graph:
                graph[start] = []
            # graph[start].append(end)
            heapq.heappush(graph[start], end)
        ans = []

        def dfs(start):
            while graph[start]:
                dfs(heapq.heappop())
            ans.append(start)

        dfs("JFK")
        return ans
