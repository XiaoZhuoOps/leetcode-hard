package Lc1106

// BoolExpr is an expression whose result is true or false,
// BoolExpr is an expression that evaluates to either true of false
// the constraints that BoolExpr should follow as following:
// it can be in one of following shapes
// it can be in one of the following shapes
// 1 括号解析 递归
// 1 &(exp)
// 1 &(exp,exp)
// 2 ASCII ( ) ,
func parseBoolExpr(expression string) bool {
	var f func(exp string, left int, right int) bool
	f = func(exp string, left int, right int) bool {
		switch exp[left] {
		case 't':
			return true
		case 'f':
			return false
		case '!':
			return !f(exp, left+2, right-1)
		case '&':
			nLeftBracket, left, j := 1, left+2, left+2
			res := true
			for ; j < right; j++ {
				if exp[j] == '(' {
					nLeftBracket += 1
				} else if exp[j] == ')' {
					nLeftBracket -= 1
				}
				if nLeftBracket == 1 && exp[j] == ',' {
					res = res && f(exp, left, j-1)
					left = j + 1
				}
			}
			return res && f(exp, left, j-1)
		case '|':
			nLeftBracket, left, j := 1, left+2, left+2
			res := false
			for ; j < right; j++ {
				if exp[j] == '(' {
					nLeftBracket += 1
				} else if exp[j] == ')' {
					nLeftBracket -= 1
				}
				if nLeftBracket == 1 && exp[j] == ',' {
					res = res || f(exp, left, j-1)
					left = j + 1
				}
			}
			return res || f(exp, left, j-1)
		}
		return true
	}
	return f(expression, 0, len(expression)-1)
}
