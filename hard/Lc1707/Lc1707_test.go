package Lc1707

import "testing"

func Test_Lc1707(t *testing.T) {
	a, b := 4, 3
	tree := newTrie()
	tree.add(a)
	t.Logf("trie: %v \n", tree.query(b))
	t.Logf("xor: %v \n", a^b)
}
