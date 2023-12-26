package Lc2246

// you are given a tree (i.e. a connected, undirected graph that has no cycles)
// consisted of n
// nodes with number ranged from 0 to n-1
// nodes numbered from 0 to n-1.
// an 0-indexed array of size n named parent is used to represent this tree,
// where parent[i] is the parent of node i
// since node 0 is root node, parent[0] = -1
// you are given another string s in which s[i] is char assigned to node i
// please find the longest path such that no adj nodes in this tree have same char, and return its length
// 递归
//
func longestPath(parent []int, s string) int {
	n := len(parent)
	tree := make([][]int, n)
	for i := 1; i < n; i++ {
		tree[parent[i]] = append(tree[parent[i]], i)
	}

	g := func(a int, b int, c int) (int, int) {
		if c <= a {
		} else if c <= b {
			a = c
		} else {
			a = b
			b = c
		}
		return a, b
	}

	res := 1
	var f func(i int) int
	f = func(i int) int {
		a, b := 1, 1
		for _, ch := range tree[i] {
			c := 1 + f(ch)
			if s[i] == s[ch] {
				c = 1
			}
			a, b = g(a, b, c)
		}
		if res < (a + b - 1) {
			res = a + b - 1
		}
		return b
	}
	f(0)
	return res
}
