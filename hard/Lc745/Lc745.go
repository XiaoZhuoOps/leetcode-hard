package Lc745

// apple
type node struct {
	p, s      uint8
	lastIndex int
	chs       []*node
}

type WordFilter struct {
	root *node
}

func Constructor(words []string) WordFilter {
	wf := WordFilter{root: &node{chs: make([]*node, 0)}}
	for j, word := range words {
		cur := wf.root
		for i := 0; i < len(word); i++ {
			var next *node
			for _, ch := range cur.chs {
				if ch.p == word[i] && ch.s == word[len(word)-i-1] {
					next = ch
					break
				}
			}
			if next == nil {
				next = &node{p: word[i], s: word[len(word)-i-1], chs: make([]*node, 0)}
				cur.chs = append(cur.chs, next)
			}
			cur = next
			cur.lastIndex = j
		}
	}
	return wf
}

func (this *WordFilter) F(pref string, suff string) int {
	// assert len(pref) == len(suff)
	maxLen := max(len(pref), len(suff))
	for i := 0; i < maxLen-len(pref); i++ {
		pref += "*"
	}
	for i := 0; i < maxLen-len(suff); i++ {
		suff = "*" + suff
	}
	return this.f(pref, suff, 0, this.root)
}

func (this *WordFilter) f(pref string, suff string, i int, cur *node) int {
	res := -1
	if i == len(pref) {
		return cur.lastIndex
	}
	for _, ch := range cur.chs {
		if match(ch, pref[i], suff[len(pref)-1-i]) {
			res = max(this.f(pref, suff, i+1, ch), res)
		}
	}
	return res
}

func match(cur *node, p, s uint8) bool {
	if p == '*' {
		return s == cur.s
	}
	if s == '*' {
		return p == cur.p
	}
	return cur.p == p && cur.s == s
}

func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}

/**
 * Your WordFilter object will be instantiated and called as such:
 * obj := Constructor(words);
 * param_1 := obj.F(pref,suff);
 */
