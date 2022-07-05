"""
2022年7月5日 
"""
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


s = input()
ns = s.split(' ')
nums = [(i, int(ns[i])) for i in range(len(ns))]
t = int(input())
solution = Solution()
print(solution.twoSum(nums, t))
