
func lexicographicalLess(a, b []int) bool {
for i := 0; i < len(a) && i < len(b); i++ {
if a[i] != b[i] {
return a[i] < b[i]
}
}
return len(a) < len(b)
}

func merge(a, b []int) []int {
merged := make([]int, len(a)+len(b))
for i := range merged {
if lexicographicalLess(a, b) {
merged[i], b = b[0], b[1:]
} else {
merged[i], a = a[0], a[1:]
}
}
return merged
}

func maxNumber(nums1, nums2 []int, k int) (res []int) {
start := 0
if k > len(nums2) {
start = k - len(nums2)
}
for i := start; i <= k && i <= len(nums1); i++ {
s1 := removeK(nums1, len(nums1)-i)
s2 := removeK(nums2, len(nums2)-k+i)
merged := merge(s1, s2)
if lexicographicalLess(res, merged) {
res = merged
}
}
return
}

// [4,8,1] 1
// [8,1]
// 删除k个数，使得剩余的数顺序不变的同时组成的数最大
func removeK(nums []int, k int) []int {
	s := NewStack()
	for _, num := range nums {
		for 0 < k && !s.IsEmpty() && s.Top() < num {
			s.Pop()
			k -= 1
		}
		s.Push(num)
	}
	// k [0,a) k+a=len
	return s.Underlying()[:len(s.Underlying())-k]
}
