package Lc68

import "strings"

//
// 模拟
// left right
// blank 返回长度为 n 的由空格组成的字符串
// 输入: words = ["This", "is", "an", "example", "of", "text", "justification."], maxWidth = 16
//                                    right
// 输出:
//[
//   "This    is    an",
//   "example  of text",
//   "justification.  "
//]
func blank(n int) string {
	return strings.Repeat(" ", n)
}

func fullJustify(words []string, maxWidth int) (ans []string) {
	n, left := len(words), 0
	for left < n {
		lenLine, right := 0, left
		//	找到这一行满足的所有单词
		for right < n && lenLine+len(words[right]) <= maxWidth {
			lenLine += len(words[right]) + 1
			right++
		}
		//	如果是最后一行
		if right == n {
			s := strings.Join(words[left:], " ")
			ans = append(ans, s+blank(maxWidth-len(s)))
			return
		}
		numWords, numSpaces := right-left, maxWidth-lenLine+right-left
		//	如果只有一个单词
		if numWords == 1 {
			ans = append(ans, words[left]+blank(numSpaces))
		} else {
			//	多于一个单词
			avgSpaces := numSpaces / (numWords - 1)
			extraSpaces := numSpaces % (numWords - 1)
			s1 := strings.Join(words[left:left+extraSpaces+1], blank(avgSpaces+1)) // 拼接额外加一个空格的单词
			s2 := strings.Join(words[left+extraSpaces+1:right], blank(avgSpaces))  // 拼接其余单词
			ans = append(ans, s1+blank(avgSpaces)+s2)
		}
		left = right
	}
	return
}
