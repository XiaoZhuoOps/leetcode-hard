package hard

// "ab" "a*."
// 1.dp
//
//	dp[i][j] [i][j+1]
//	[i+1][j] [i+1][j+1]
//
// abcd  ab.*
//
//	i     j
//
// 转移方程 分类讨论 递归
// for i
//
//	for j
//
// |或
// if p[j] == * then dp[i][j] = dp[i][j-2] || dp[i-1][j] && match(i,j-1)
// if p[j] != * then dp[i][j] = dp[i-1][j-1] && match(i,j)
func isMatch(s string, p string) bool {
	m, n := len(s), len(p)
	dp := make([][]bool, m+1)
	for i, _ := range dp {
		dp[i] = make([]bool, n+1)
	}
	dp[0][0] = true
	for j := 2; j <= n; j++ {
		if p[j-1] == '*' {
			dp[0][j] = dp[0][j] || dp[0][j-2]
		}
	}
	match := func(i int, j int) bool {
		return s[i-1] == p[j-1] || p[j-1] == '.'
	}
	for i := 1; i <= m; i++ {
		for j := 1; j <= n; j++ {
			if p[j-1] == '*' {
				if j-2 >= 0 {
					dp[i][j] = dp[i][j-2] || (dp[i-1][j] && match(i, j-1))
				}
			} else {
				dp[i][j] = dp[i-1][j-1] && match(i, j)
			}
		}
	}
	return dp[m][n]
}
