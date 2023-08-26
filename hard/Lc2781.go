// cbaaaaabc
// ["aaaa","cb"]
// i    j x. [j-i]
//
//	i   j
//
// .   i jj
// .    i    ]j
// 双指针
//
// 心无外物，心无外物，保持绝对的专注，三位一体，脑-嘴-手，三位一体，眼前的事情最重要，其他人与我无关
// 心无外物
// word = "leetcode", forbidden = ["de","le","e"]
//
//	ij
//
// left right越界
//
// left跳转最长不重复字符
func longestValidSubstring(word string, forbidden []string) int {
	ans := -1
	//map
	m := map[string]bool{}
	for _, f := range forbidden {
		m[f] = true
	}
	//for
	left, right, ls := 0, 0, len(word)
	for right < ls {
		// i right-i+1<=10
		for i := right; right-i <= 9 && left <= i; i-- {
			if m[word[i:right+1]] == true {
				//move i
				left = i + 1
				break
			}
		}
		//break or end
		ans = max(ans, right-left+1)
		right += 1
	}
	return ans
}

func max(a int, b int) int {
	if a > b {
		return a
	} else {
		return b
	}
}