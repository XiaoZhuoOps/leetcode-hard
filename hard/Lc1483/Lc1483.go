package Lc1483

// 倍增
// ancestor[i][j] = ancestor[ancestor[i][j-1]][j-1]

const k = 16

type TreeAncestor struct {
	ancestor [][]int
}

func Constructor(n int, parent []int) TreeAncestor {
	var cur TreeAncestor
	ancestor := make([][]int, n)
	cur.ancestor = ancestor

	// init
	for i := 0; i < n; i++ {
		cur.ancestor[i] = make([]int, k)
		for j := 0; j < k; j++ {
			cur.ancestor[i][j] = -1
		}
		cur.ancestor[i][0] = parent[i]
	}

	// build
	for j := 1; j < k; j++ {
		for i := 0; i < n; i++ {
			if ancestor[i][j-1] != -1 {
				cur.ancestor[i][j] = cur.ancestor[ancestor[i][j-1]][j-1]
			}
		}
	}
	return cur
}

func (this *TreeAncestor) GetKthAncestor(node int, j int) int {
	for i := k; 0 < j && 0 <= i; i-- {
		if (j>>i)&1 != 0 {
			node = this.ancestor[node][i]
			if node == -1 {
				return -1
			}
			j -= 1 << i
		}
	}
	return node
}

/**
 * Your TreeAncestor object will be instantiated and called as such:
 * obj := Constructor(n, parent);
 * param_1 := obj.GetKthAncestor(node,k);
 */
