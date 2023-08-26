// 模拟 - 链表
// []abcd
// add
// goland debug
// 30min+
type TextEditor struct {
	cursor *Node
	head   *Node
}

func (t *TextEditor) String() {
	ptr := t.head
	for {
		ptr = ptr.right
		if ptr == nil {
			break
		}
		fmt.Print(string(ptr.val))
	}
	fmt.Print("\n")
}

type Node struct {
	val   rune
	left  *Node
	right *Node
}

func Constructor() TextEditor {
	tx := &TextEditor{}
	tx.head = &Node{}
	tx.cursor = tx.head
	return *tx
}

func (this *TextEditor) AddText(text string) {
	// b - c - t
	// cursor
	for _, s := range text {
		nodePtr := &Node{val: s, left: this.cursor, right: this.cursor.right}
		if this.cursor.right != nil {
			this.cursor.right.left = nodePtr
		}
		this.cursor.right = nodePtr
		this.cursor = nodePtr
	}
}

func (this *TextEditor) DeleteText(k int) int {
	// [] - h - a - b - c - t
	//     cursor
	rn := 0
	for i := 0; i < k; i++ {
		if this.cursor == this.head {
			break
		}
		this.cursor.left.right = this.cursor.right
		if this.cursor.right != nil {
			this.cursor.right.left = this.cursor.left
		}
		// TODO ptr to something will be gabege
		this.cursor = this.cursor.left
		rn += 1
	}
	return rn
}

func (this *TextEditor) CursorLeft(k int) string {
	// [] - h - a - b - c
	//     cursor
	//
	for i := 0; i < k; i++ {
		if this.cursor == this.head {
			break
		}
		this.cursor = this.cursor.left
	}
	// min(10,leftString)
	s := []rune{}
	ptr := this.cursor
	for i := 0; i < 10; i++ {
		if ptr == this.head {
			break
		}
		// array
		s = append(s, ptr.val)
		ptr = ptr.left
	}
	rs := []rune{}
	for i := len(s) - 1; 0 <= i; i-- {
		rs = append(rs, s[i])
	}
	return string(rs)
}

func (this *TextEditor) CursorRight(k int) string {
	for i := 0; i < k; i++ {
		if this.cursor.right == nil {
			break
		}
		this.cursor = this.cursor.right
	}
	// min(10,leftString)
	s := []rune{}
	ptr := this.cursor
	for i := 0; i < 10; i++ {
		if ptr == this.head {
			break
		}
		s = append(s, ptr.val)
		ptr = ptr.left
	}
	rs := []rune{}
	for i := len(s) - 1; 0 <= i; i-- {
		rs = append(rs, s[i])
	}
	return string(rs)
}
