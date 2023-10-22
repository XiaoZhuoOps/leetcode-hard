package Lc212

import . "github.com/xiaozhuoops/leetcode/template/trie"

//dfs+trie
//i,j node,k dfs()
//special case: "ab" "abc"
type pos = [2]int

func findWords(board [][]byte, words []string) []string {
	// build trie
	trie := Trie{}
	for _, word := range words {
		trie.Insert(word)
	}
	// dfs
	ans := make(map[string]struct{})
	m, n := len(board), len(board[0])
	dirs := []pos{{1, 0}, {-1, 0}, {0, 1}, {0, -1}}
	vis := make(map[pos]bool)

	var dfs func(x int, y int, node *Trie)
	dfs = func(x int, y int, par *Trie) {
		if 0 > x || 0 > y || x >= m || y >= n || vis[pos{x, y}] {
			return
		}
		node := par.Chs[board[x][y]-'a']
		if node == nil {
			return
		} else if node.Word != "" {
			ans[node.Word] = struct{}{}
			//return
		}
		vis[pos{x, y}] = true
		for _, dir := range dirs {
			dfs(x+dir[0], y+dir[1], node)
		}
		vis[pos{x, y}] = false
	}
	for i := 0; i < m; i++ {
		for j := 0; j < n; j++ {
			dfs(i, j, &trie)
		}
	}
	var ansList []string
	for k := range ans {
		ansList = append(ansList, k)
	}
	return ansList
}
