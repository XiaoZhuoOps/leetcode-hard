package Lc1402

import (
	"math"
	"sort"
)

// 组合
// 贪心
// 回溯
// 无穷项做差
// f(k) = f(k-1) + ps(k-1) f(1) = a(0) a 递减序
// f(2) = f(1) + ps[1]
func maxSatisfaction(satisfaction []int) int {
	sort.Slice(satisfaction, func(i, j int) bool {
		return satisfaction[i] > satisfaction[j]
	})
	ps := make([]int, len(satisfaction))
	ps[0] = satisfaction[0]
	for i := 1; i < len(satisfaction); i++ {
		ps[i] = ps[i-1] + satisfaction[i]
	}
	ans := math.MinInt
	f := satisfaction[0] //k=1
	for k := 2; k <= len(satisfaction); k++ {
		f += ps[k-1]
		if f > ans {
			ans = f
		}
	}
	if ans < 0 {
		return 0
	}
	return ans
}
