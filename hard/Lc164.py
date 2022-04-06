
from typing import *

class Solution:

    """
    2022年4月5日
    1 桶排序
    2 n
    3
    """
    def maximumGap(self, nums: List[int]) -> int:
        if len(nums) < 2:
            return 0
        n, maxVal, minVal = len(nums), max(nums), min(nums)
        bucketSize = max(1, (maxVal - minVal) // (n - 1))
        bucketNum = (maxVal - minVal) // bucketSize + 1

        bucket = [[-1 for _ in range(2)] for _ in range(bucketNum)]
        for num in nums:
            i = (num - minVal) // bucketSize
            if bucket[i][0] == -1:
                bucket[i][0] = bucket[i][1] = num
            else:
                bucket[i][0] = min(bucket[i][0], num)
                bucket[i][1] = max(bucket[i][1], num)

        ans = -1
        for i in range(1, bucketSize):
            ans = max(ans, bucket[i][0] - bucket[i-1][1])
        return ans

    """
    2022年4月5日
    1 基数排序
    2 O(n)
    3 
    """
    def radixSort(self, nums: List[int]) -> List[int]:
        def get(num, idx):
            for _ in range(idx-1):
                num //= 10
            return num % 10
        maxVal, idx = max(nums), 1
        while maxVal > 0:
            radix = [[] for _ in range(10)]
            for num in nums:
                radix[get(num, idx)].append(num)
            i = 0
            for rs in radix:
                for r in rs:
                    nums[i] = r
                    i += 1
            idx += 1
            maxVal //= 10
        return nums

    # def main(self):
    #     self.maximumGap([3, 6, 9, 1])
    #
    # if __name__ == "__main__":
    #     main()
