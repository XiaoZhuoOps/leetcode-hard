"""
2022年7月5日 
"""
from operator import le
from turtle import left, right
from typing import List


class Solution:
    def twoSum(self, nums: List, target: int) -> List[int]:
        i, j = 0, len(nums)-1
        nums.sort(key=lambda x: x[1])
        while i < j:
            sum = nums[i][1] + nums[j][1]
            if sum > target:
                j -= 1
            elif sum == target:
                return [nums[i][0], nums[j][0]]
            else:
                i += 1
        return -1

    def bs(self, nums, target):
        left, right = 0, len(nums)-1
        while left < right:
            mid = (left+right+1) >> 1
            if nums[mid] <= target:
                left = mid
            else:
                right = mid-1
        return nums[left]

    def commonNum(nums1, nums2):
        i, j, ls1, ls2 = 0, 0, len(nums1), len(nums2)
        ans = []
        while i < ls1 and j < ls2:
            if nums1[i] < nums2[j]:
                i += 1
            elif nums1[i] > nums2[j]:
                j += 1
            else:
                ans.append(nums1[i])
                i += 1
                j += 1
        return ans
# s = input()
# ns = s.split(' ')
# nums = [(i, int(ns[i])) for i in range(len(ns))]
# t = int(input())
# solution = Solution()
# print(solution.twoSum(nums, t))


# s = input()
# ns = s.split(' ')
# nums = [int(ch) for ch in ns]
# solution = Solution()
# print(solution.bs(nums, 4))

s = input()
ns = s.split(' ')
nums1 = [int(ch) for ch in ns]

s = input()
ns = s.split(' ')
nums2 = [int(ch) for ch in ns]
print(Solution.commonNum(nums1, nums2))


public boolean dfs(TreeNode parent, TreeNode children) {
    if(parent == null & & children == null) {
        return true
    }
    if (parent == null | | children == null){
        return false
    }
    if(parent.val == children.val) {
        return (dfs(parent.left, children.left) & & dfs(parent.right, children.right)) | | dfs(parent.left, children) | | dfs(parent.right, children)
    }
    reutrn dfs(parent.left, children) | | dfs(parent.right, children)
}
