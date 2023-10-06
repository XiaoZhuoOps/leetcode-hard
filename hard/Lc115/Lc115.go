package Lc115

// step 1
// string
// dp
// brute
// s = "babgba|g", t = "ba|g"
//
//	i            j
//
// step 2
// dp[i][j]
// if s[i-1] == t[j-1] dp[i][j] = dp[i-1][j-1]
// 来源 dp[i][j] = dp[i-1][j]
// initial dp[0][0] = 1 dp[0][j] = 0 dp[i][0] = 1
// dp[1][1] = dp[0][1] + dp[0][0] if s[0] == t[0] = 1
// bba a 1
// dp[2][1] = dp[1][1] + dp[1][0] if s[1] == t[0] -> dp[1][0] = 1
// dp[3][1] = dp[2][1] + dp[2][0] if s[2] == t[0] -> dp[2][0] = 1
//
//	1          0          1
func numDistinct(s string, t string) int {
	m, n := len(s)+1, len(t)+1
	dp := make([][]int, m)
	for i, _ := range dp {
		dp[i] = make([]int, n)
	}
	// initial
	for j := 0; j < n; j++ {
		dp[0][j] = 0
	}
	for i := 0; i < m; i++ {
		dp[i][0] = 1
	}
	// format
	for i := 1; i < m; i++ {
		for j := 1; j < n; j++ {
			dp[i][j] = dp[i-1][j]
			if s[i-1] == t[j-1] {
				dp[i][j] += dp[i-1][j-1]
			}
		}
	}
	return dp[m][n]
}
