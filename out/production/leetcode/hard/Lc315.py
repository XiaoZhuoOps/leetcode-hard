# 归并排序
# NlogN
#
class Struct:
    def __init__(self, num, i) -> None:
        self.num = num
        self.i = i

class Solution:
    def countSmaller(self, nums: List[int]) -> List[int]:
        newNums = []
        ans = [0]*len(nums)

        for i, num in enumerate(nums):
            newNums.append(Struct(num, i))

        def mergeSort(nums, left, right):
            if left >= right:
                return 
            mid = (left+right+1)//2
            mergeSort(nums, left, mid-1)
            mergeSort(nums, mid, right)
            merge(nums, left, mid, right)

        def merge(nums, left, mid, right):
            res = []
            i, j = left, mid
            while i <= mid-1 and j <= right:
                if nums[i].num <= nums[j].num:
                    res.append(nums[i])
                    ans[nums[i].i] += j-mid+1
                    i += 1
                else:
                    res.append(nums[j])
                    j += 1
            res += nums[i:mid]
            res += nums[j:right+1]
            for k in range(i,mid):
                ans[nums[k].i] += right-mid+1
            nums[left:right+1] = res

        mergeSort(newNums, 0, len(newNums)-1)
        return ans