package Lc992

// 思路1
// sw double pointer
// nums = [1,2,1,3,4], k = 3
//         i       j     k
//           i        j
// exist? map end

// 思路2
// 两次sw
func subarraysWithKDistinct(nums []int, m int) int {
	sw := func(m int) int {
		if m == 0 {
			return 0
		}
		j, l, cnt, ans := 0, len(nums), 0, 0 // [i,j)
		times := make(map[int]int)
		for i := 0; i < l; i++ {
			if cnt < m {
				for ; j < l; j++ {
					if times[nums[j]] == 0 {
						if cnt == m {
							break
						}
						cnt += 1
					}
					times[nums[j]] += 1
				}
			}
			ans += j - i
			times[nums[i]] -= 1
			if times[nums[i]] == 0 {
				cnt -= 1
			}
		}
		return ans
	}
	return sw(m) - sw(m-1)
}
