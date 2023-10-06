package Lc1723

import (
	"fmt"
	"math"
)

// 1. bin search + backTrack
// 2.
// 3. TLE
// 3.1. 剪枝
// 3.2. 优化回溯方向
func minimumTimeRequired(jobs []int, k int) int {
	max, sum := 0, 0
	for _, job := range jobs {
		sum += job
		max = int(math.Max(float64(job), float64(max)))
	}

	// left boundary
	left, right := max, sum+1
	for left < right {
		fmt.Println(left, right)
		mid := (left + right) >> 1
		if isOk(jobs, 0, make([]int, k), mid) {
			right = mid
		} else {
			left = mid + 1
		}
	}
	return left
}

func isOk(jobs []int, i int, ks []int, limit int) bool {
	if i == len(jobs) {
		return true
	}
	for j, k := range ks {
		// cut 1
		if k+jobs[i] > limit {
			continue
		}
		ks[j] += jobs[i]
		if isOk(jobs, i+1, ks, limit) {
			return true
		}
		ks[j] -= jobs[i]
		// cut 2
		if ks[j] == 0 || ks[j]+jobs[i] == limit {
			break
		}
	}
	return false
}
