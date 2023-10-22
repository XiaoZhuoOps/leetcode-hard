package Lc315

// [5,2,6,1]
// 比i小的第一个元素的位置
// f(i)
// 归并排序
// a---b---c
// 递归性质
//
func countSmaller(nums []int) []int {
	ans := make([]int, len(nums))
	var mergeSort func(numIndexs []numIndex, left int, right int)
	mergeSort = func(numIndexs []numIndex, left int, right int) {
		if left == right {
			return
		}
		mid := (left + right + 1) / 2
		mergeSort(numIndexs, left, mid-1)
		mergeSort(numIndexs, mid, right)
		//merge
		merged := make([]numIndex, 0, right-left+1)
		i, j := left, mid
		for i < mid && j <= right {
			if numIndexs[i].num > numIndexs[j].num {
				merged = append(merged, numIndexs[i])
				ans[numIndexs[i].index] += right - j + 1
				i += 1
			} else {
				merged = append(merged, numIndexs[j])
				j += 1
			}
		}
		for k := i; k < mid; k++ {
			merged = append(merged, numIndexs[k])
		}
		for k := j; k <= right; k++ {
			merged = append(merged, numIndexs[k])
		}
		for k := 0; k < len(merged); k++ {
			numIndexs[left+k] = merged[k]
		}
	}
	numIndexs := make([]numIndex, len(nums))
	for i, num := range nums {
		numIndexs[i] = numIndex{num, i}
	}
	mergeSort(numIndexs, 0, len(numIndexs)-1)
	return ans
}

type numIndex struct {
	num   int
	index int
}
