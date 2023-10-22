package Lc2850

import "math"

// permutations
type pos struct {
	x int
	y int
}

const MaxInt = 10000

func minimumMoves(grid [][]int) int {
	permutations := func(nums []pos) (ans [][]pos) {
		n := len(nums)
		path := make([]pos, n)
		onPath := make([]bool, n)
		var dfs func(i int)
		dfs = func(i int) {
			if i == n {
				newPos := make([]pos, len(path))
				copy(newPos, path)
				ans = append(ans, newPos)
				return
			}
			for j, on := range onPath {
				if !on {
					path[i] = nums[j]
					onPath[j] = true
					dfs(i + 1)
					onPath[j] = false
				}
			}
		}
		dfs(0)
		return
	}

	dis := func(pa pos, pb pos) int {
		return int(math.Abs(float64(pa.x-pb.x)) + math.Abs(float64(pa.y-pb.y)))
	}
	var from, to []pos
	for i := 0; i < 3; i++ {
		for j := 0; j < 3; j++ {
			if grid[i][j] > 1 {
				for k := 0; k < grid[i][j]-1; k++ {
					from = append(from, pos{x: i, y: j})
				}
			} else if grid[i][j] == 0 {
				to = append(to, pos{x: i, y: j})
			}
		}
	}
	res := MaxInt
	for _, perm := range permutations(to) {
		cnt := 0
		for i, p := range perm {
			cnt += dis(p, from[i])
		}
		if cnt < res {
			res = cnt
		}
	}
	return res
}
