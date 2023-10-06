package Lc632

import (
	"math"
	"sort"
)

// step 1
// 3500*50 区间 排序 离散点 滑动窗口
// step 2
// map[][] cnt
// step 3
type point struct {
	val  int
	from int //0
}

func smallestRange(nums [][]int) []int {
	// sort
	var arr []point
	leftMax := math.MaxInt
	for i, num := range nums {
		//arr = append(arr, num...)
		for _, val := range num {
			arr = append(arr, point{val: val, from: i})
		}
		leftMax = int(math.Min(float64(num[len(num)-1]), float64(leftMax)))
	}
	sort.Slice(arr, func(i, j int) bool {
		return arr[i].val < arr[j].val
	})
	// slide window
	m := make(map[int]int) //form->cnt
	times, n, left, ans := 0, len(nums), math.MaxInt, math.MaxInt
	j := -1 //[arr[i], arr[j]]
	for i := 0; arr[i].val <= leftMax; i++ {
		if times < n {
			for j = j + 1; j < len(arr) && times < n; j++ {
				m[arr[j].from] += 1
				if m[arr[j].from] == 1 {
					times += 1
				}
			}
			// j == len(arr) || times == n
			if times < n {
				break
			}
		}
		if arr[j].val-arr[i].val+1 < ans {
			ans = arr[j].val - arr[i].val + 1
			left = arr[i].val
		}
		m[arr[i].from] -= 1
		if m[arr[i].from] == 0 {
			times -= 1
		}
	}
	return []int{left, left + ans - 1}
}
