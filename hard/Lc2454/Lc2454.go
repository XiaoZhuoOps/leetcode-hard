package Lc2454

// i k j
// nums[i] < nums[k]
// nums[i] < nums[j]
// >= 0
// stack trick
// find the first greater num
// ms1 ms2 -> index
// res
func secondGreaterElement(nums []int) []int {
	//
	res := make([]int, len(nums))
	for i := 0; i < len(nums); i++ {
		res[i] = -1
	}
	//
	ms1, ms2 := make([]int, 0), make([]int, 0)
	for i := 0; i < len(nums); i++ {
		for len(ms2) > 0 && nums[ms2[len(ms2)-1]] < nums[i] {
			res[ms2[len(ms2)-1]] = nums[i]
			ms2 = ms2[:len(ms2)-1]
		}
		j := len(ms1) - 1
		for j >= 0 && nums[ms1[j]] < nums[i] {
			j--
		}
		// (j
		ms2 = append(ms2, ms1[j+1:]...)
		ms1 = append(ms1, i)
	}
	return res
}
