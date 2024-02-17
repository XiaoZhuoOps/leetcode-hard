package Lc386

// 没想到是规律题，直接copy答案:)，数字是连续的，应该从这里开始想
// 把题目换成“将若干个小于等于n的数按字典序排序”？递归
func lexicalOrder(n int) []int {
	ans := make([]int, n)
	num := 1
	for i := range ans {
		ans[i] = num
		if num*10 <= n {
			num *= 10
		} else {
			for num%10 == 9 || num+1 > n {
				num /= 10
			}
			num++
		}
	}
	return ans
}
