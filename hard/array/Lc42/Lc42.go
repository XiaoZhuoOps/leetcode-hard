package Lc42

/*
*
Given n non-negative integers representing a Revelation map where the width of each bar is 1,
compute how much water it can trap after raining

mono stack
hMax = min(leftMax[i], rightMax[i])
1. 左右最大值最小值问题
2.
*/
func trap(height []int) int {
	min := func(a int, b int) int {
		if a < b {
			return a
		}
		return b
	}
	n := len(height)
	leftMaxs, rightMaxs := make([]int, n), make([]int, n)
	leftMaxs[0] = height[0]
	for i := 1; i < n; i++ {
		if height[i] > leftMaxs[i-1] {
			leftMaxs[i] = height[i]
		} else {
			leftMaxs[i] = leftMaxs[i-1]
		}
	}
	rightMaxs[n-1] = height[n-1]
	for i := n - 2; 0 <= i; i-- {
		if height[i] > rightMaxs[i+1] {
			rightMaxs[i] = height[i]
		} else {
			rightMaxs[i] = rightMaxs[i+1]
		}
	}
	res := 0
	for i := 1; i < n-1; i++ {
		res += min(leftMaxs[i], rightMaxs[i]) - height[i]
	}
	return res
}
