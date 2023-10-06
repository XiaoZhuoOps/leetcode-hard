package Lc1707

import "sort"

// 1.Trie bitTree 2**30 > 10**9 32
// 2.Node{} [01]
func maximizeXor(nums []int, queries [][]int) []int {
	// 对 nums 进行排序
	sort.Ints(nums)

	for i, _ := range queries {
		queries[i] = []int{queries[i][0], queries[i][1], i}
	}
	// 对 queries 进行排序，按照每个子切片的第二个元素从小到大排序
	sort.Slice(queries, func(i, j int) bool {
		return queries[i][1] < queries[j][1]
	})

	t := newTrie()
	j := 0
	ans := make([]int, len(queries))
	for i := 0; i < len(queries); i++ {
		for ; j < len(nums) && nums[j] <= queries[i][1]; j++ {
			t.add(nums[j])
		}
		if j == 0 {
			ans[queries[i][2]] = -1
		} else {
			a := t.query(queries[i][0])
			ans[queries[i][2]] = a
		}
	}
	return ans
}

type node struct {
	ch []*node
}

type trie struct {
	root *node //32
}

func newTrie() trie {
	return trie{
		root: &node{
			ch: make([]*node, 2),
		},
	}
}

func (t *trie) add(num int) {
	par := t.root
	for i := 31; 0 <= i; i-- {
		bit := (1 << i) & num
		if bit == 0 {
			if par.ch[0] == nil {
				par.ch[0] = &node{ch: make([]*node, 2)}
			}
			par = par.ch[0]
		} else {
			if par.ch[1] == nil {
				par.ch[1] = &node{ch: make([]*node, 2)}
			}
			par = par.ch[1]
		}
	}
}

// 0 1
// 1 0
func (t *trie) query(x int) int {
	ans := 0
	cur := t.root
	getReverse := func(i int, x int) int {
		bit := (1 << i) & x
		if bit == 0 {
			return 1
		} else {
			return 0
		}
	}
	for i := 31; 0 <= i; i-- {
		// how to simplify code
		r := getReverse(i, x) // 0 or 1
		if cur.ch[r] == nil {
			r = 1 - r
		} else {
			ans |= 1 << i
		}
		cur = cur.ch[r]
	}
	return ans
}
