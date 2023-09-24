package Lc847

import . "github.com/xiaozhuoops/leetcode/template/deque"

// 1.bfs+状态压缩
// 2.dummy node queue mask set
// 3.
type node struct {
	p      int
	status uint16
}

func shortestPathLength(graph [][]int) int {
	// 1.dumpyNode
	dq := Deque{}
	for i, _ := range graph {
		dq.PushLeft(node{
			p:      i,
			status: 1 << i,
		})
	}

	depth := 0
	vis := make(map[node]bool)
	// 2.bfs
	for dq.Len() > 0 {
		n := dq.Len()
		for i := 0; i < n; i++ {
			curNode := (dq.PopRight()).(node)
			if curNode.status+1 == (1 << len(graph)) {
				return depth
			}
			for _, adj := range graph[curNode.p] {
				adjNode := node{
					p:      adj,
					status: curNode.status | (1 << adj),
				}
				if _, ok := vis[adjNode]; !ok {
					dq.PushLeft(adjNode)
					vis[adjNode] = true
				}
			}
		}
		depth += 1
	}
	return 0
}
