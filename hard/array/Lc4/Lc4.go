package Lc4

/*
*
Given two sorted array nums1 and nums2 of size m and n respectively,
return the median of the two sorted arrays

run time complexity

1 log
*/
func findMedianSortedArrays(nums1 []int, nums2 []int) float64 {
	return merge(nums1, nums2)
}

// 2+2 (m+n)/2 (m+n)/2+1
// 2+3 (m+n)/2+1
var merge = func(nums1 []int, nums2 []int) float64 {
	n1, n2 := len(nums1), len(nums2)
	i, j, last, cur := 0, 0, -1, -1
	for k := 0; k < ((n1+n2)>>1)+1; k++ {
		last = cur
		if i < n1 && (j >= n2 || nums1[i] < nums2[j]) {
			cur = nums1[i]
			i++
		} else {
			cur = nums2[j]
			j++
		}
	}
	if (n1+n2)%2 == 1 {
		return float64(cur)
	} else {
		return (float64(cur) + float64(last)) / 2
	}
}

var binSearch = func(nums1 []int, nums2 []int) float64 {
	/*
		"""
		1 bs
		2 i1 i2 k k//2-1
		3 -
		4 -
		"""
		class Solution:
		    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
		        n1, n2 = len(nums1), len(nums2)
		        def getK(nums1, nums2, idx1, idx2, k):
		            nonlocal n1, n2
		            while True:
		                # base
		                if idx1 == n1:
		                    return nums2[idx2+k-1]
		                if idx2 == n2:
		                    return nums1[idx1+k-1]
		                if k == 1:
		                    return min(nums1[idx1], nums2[idx2])

		                p1 = min(idx1+k//2-1, n1-1)
		                p2 = min(idx2+k//2-1, n2-1)
		                if nums1[p1] <= nums2[p2]:
		                    k -= (p1-idx1+1)
		                    idx1 = p1+1
		                else:
		                    k -= (p2-idx2+1)
		                    idx2 = p2+1
		        if (n1+n2)%2 == 1:
		            return getK(nums1, nums2, 0, 0, (n1+n2)//2+1)
		        else:
		            return (getK(nums1, nums2, 0, 0, (n1+n2)//2+1)+getK(nums1, nums2, 0, 0, (n1+n2)//2))/2
	*/
	return 0
}
