package Lc871

import (
	"container/heap"
	. "github.com/xiaozhuoops/leetcode/template/heap"
)

// 回溯 + 贪心 + 优先级队列
// cur heap -1
func minRefuelStops(target int, cur int, stations [][]int) int {
	stations = append(stations, []int{target, 0})
	hp := &IntHeap{}
	heap.Init(hp)

	cnt, pos, n := 0, 0, len(stations)
	for i := 0; i < n; i++ {
		need := stations[i][0] - pos
		if cur >= need {
			//
		} else {
			for len(*hp) > 0 && cur < need {
				cur += (heap.Pop(hp)).(int)
				cnt += 1
			}
			if cur < need {
				return -1
			}
		}
		cur = cur - need
		pos = stations[i][0]
		heap.Push(hp, stations[i][1])
	}
	return cnt
}
