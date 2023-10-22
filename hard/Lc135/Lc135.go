package Lc135

// 极值问题 a b c
// 贪心
// dp
// 递增递减序列
// lastPeek length i j up down
// 1 2 3 3 2 1 2
//       j     i
//           1
func candy(ratings []int) int {
	if len(ratings) == 1 {
		return 1
	}
	i, ans, last := 1, 1, 1
	for i < len(ratings) {
		if ratings[i-1] < ratings[i] {
			last += 1
			ans += last
			i += 1
		} else if ratings[i-1] == ratings[i] {
			last = 1
			ans += last
			i += 1
		} else {
			j := i - 1
			// 	ratings[i-1] > ratings[i]
			for i < len(ratings) && ratings[i-1] > ratings[i] {
				i += 1
			}
			// [j, i-1]
			k := 1
			for ; k < i-j; k++ {
				ans += k
			}
			if k > last {
				ans += k - last
			}
			last = 1
		}
	}
	return ans
}
