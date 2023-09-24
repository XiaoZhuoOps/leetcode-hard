package Lc332

import (
	"container/heap"
	. "github.com/xiaozhuoops/leetcode/template/heap"
)

func findItinerary(tickets [][]string) []string {
	// 1.build graph
	graph := map[string]*StringHeap{}
	for _, ticket := range tickets {
		from, to := ticket[0], ticket[1]
		if adjList, ok := graph[from]; ok {
			heap.Push(adjList, to)
		} else {
			sh := &StringHeap{}
			heap.Init(sh)
			heap.Push(sh, to)
			graph[from] = sh
		}
	}
	// fmt.Println(graph)

	// 2.dfs
	var stack []string
	var dfs func(start string)
	dfs = func(start string) {
		for graph[start] != nil && len(*graph[start]) > 0 {
			to := heap.Pop(graph[start])
			dfs(to.(string))
		}
		stack = append(stack, start)
	}
	dfs("JFK")

	ans := make([]string, len(stack))
	for i, _ := range stack {
		ans[i] = stack[len(stack)-1-i]
	}
	return ans
}
