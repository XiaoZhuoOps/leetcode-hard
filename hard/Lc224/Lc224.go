package Lc224

// doc
// "(1+(4+5+2)-3)+(6+8)"
// [13+]
type frame struct {
	num  int
	sign bool
}

func newFrame() frame {
	return frame{num: 0, sign: true}
}

func pop(old []frame) (top int, new []frame) {
	return old[len(old)-1].num, old[:len(old)-1]
}

func push(stack []frame, n int) []frame {
	if stack[len(stack)-1].sign {
		stack[len(stack)-1].num += n
	} else {
		stack[len(stack)-1].num -= n
	}
	return stack
}

func lc224(s string) int {
	stack := []frame{newFrame()}
	top := 0
	for i := 0; i < len(s); {
		switch s[i] {
		case ' ':
			i += 1
		case '+':
			stack[len(stack)-1].sign = true
			i += 1
		case '-':
			stack[len(stack)-1].sign = false
			i += 1
		case '(':
			stack = append(stack, newFrame())
			i += 1
		case ')':
			top, stack = pop(stack)
			stack = push(stack, top)
			i += 1
		default:
			n := int(s[i] - '0')
			for i = i + 1; i < len(s) && '0' <= s[i] && s[i] <= '9'; i++ {
				n = n*10 + int(s[i]-'0')
			}
			stack = push(stack, n)
		}
	}
	return stack[0].num
}

// "-(1+(4+5+2)-3)+(6+8)"
// signStack curSign
// [+]
// -
type operatorStack struct {
	operators []bool
}

func (o *operatorStack) push(sign bool) {
	o.operators = append(o.operators, sign)
}

func (o *operatorStack) top() bool {
	if len(o.operators) == 0 {
		return true
	}
	return o.operators[len(o.operators)-1]
}

func (o *operatorStack) pop() {
	o.operators = o.operators[:len(o.operators)-1]
}

func lc224_2(s string) int {
	// stack bool +-
	res := 0
	ops := &operatorStack{}
	curSign := true
	i := 0
	for i < len(s) {
		switch s[i] {
		case '+':
			if ops.top() {
				curSign = true
			} else {
				curSign = false
			}
		case '-':
			if ops.top() {
				curSign = false
			} else {
				curSign = true
			}
		case '(':
			ops.push(curSign)
		case ')':
			ops.pop()
		case ' ':
		default:
			//0-9
			num := 0
			for ; i < len(s) && '0' <= s[i] && s[i] <= '9'; i++ {
				num = 10*num + int(s[i]-'0')
			}
			if curSign {
				res += num
			} else {
				res -= num
			}
			i--
		}
		i++
	}
	return res
}
