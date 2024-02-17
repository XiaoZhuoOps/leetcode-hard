package Lc41

/*
*
Given an unsorted array nums, return the smallest missing positive integer
核心 如何减少额外空间
原地交换
[4 7 1 2]
[1 7 2 4]
[1 2 7 4]
*/
func firstMissingPositive(nums []int) int {
	n := len(nums)
	for {
		cnt := 0
		for i := 0; i < n; i++ {
			if n >= nums[i] && nums[i] > 0 && nums[i] != i+1 {
				if nums[nums[i]-1] == nums[i] {
					// 避免死循环
					continue
				}
				cnt += 1
				tmp := nums[i]
				nums[i] = nums[tmp-1]
				nums[tmp-1] = tmp
			}
		}
		if cnt == 0 {
			break
		}
	}
	for i := 0; i < n; i++ {
		if nums[i] != i+1 {
			return i + 1
		}
	}
	return -1
}
