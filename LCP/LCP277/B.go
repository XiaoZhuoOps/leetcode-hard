package LCP277

import (
	"sort"
)

// m = 4, [1,4] hFences = [2,3],
// n = 3, vFences = [2]
func maximizeSquareArea(m int, n int, hFences []int, vFences []int) int {
	ms := append([]int{1}, hFences...)
	ms = append(ms, m)
	ns := append([]int{1}, vFences...)
	ns = append(ns, n)

	sort.Ints(ms)
	sort.Ints(ns)

	hs := make([]int, 0)
	vs := make([]int, 0)
	for i := 0; i < len(ms); i++ {
		for j := i + 1; j < len(ms); j++ {
			hs = append(hs, ms[j]-ms[i])
		}
	}
	for i := 0; i < len(ns); i++ {
		for j := i + 1; j < len(ns); j++ {
			vs = append(vs, ns[j]-ns[i])
		}
	}
	sort.Ints(hs)
	sort.Ints(vs)

	MOD := int(1e9 + 7)
	i, j := len(hs)-1, len(vs)-1
	for i >= 0 && j >= 0 {
		if hs[i] == vs[j] {
			return (hs[i] * vs[j]) % MOD
		} else if hs[i] > vs[j] {
			i--
		} else {
			j--
		}
	}
	return -1
}
