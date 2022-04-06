
import bisect
import heapq
class Solution:
    """
    2022年4月2日
    1 遍历
    2 N*logK*K
    3
    """
    def medianSlidingWindow(self, nums: List[int], k: int) -> List[float]:
        window = sorted(nums[:k])

        def addMid(k, window, ans):
            if k%2 == 1:
                ans.append(window[k/2])
            else:
                ans.append((window[k/2-1]+window[k/2])/2)
        ans = []
        addMid(k, window, ans)

        ln = len(nums)
        for i in range(k, ln):
            window.pop(bisect.bisect_left(window, nums[i-k]))
            window.insert(bisect.bisect_right(window, nums[i]), nums[i])
            addMid(k, window, ans)
        return ans

    """
    2022年4月2日
    1 对顶堆
    2 N*logK
    3 
    """
    # def medianSlidingWindow2(self, nums: List[int], k: int) -> List[float]:
    #     minHeap, maxHeap = [], []
    #     minSize, maxSize = 0, 0
    #     ans = []
    #     deleted = {}
    #
    #     for num in nums[:k]:
    #         heapq.heappush(minHeap, num)
    #         minSize += 1
    #
    #     def shift():
    #
    #     shift()
    #
    #     def getMid():
    #         if minSize > maxSize:
    #             return minHeap[0]
    #         else:
    #             return (minHeap[0] + maxHeap[0])/2
    #
    #     ans.append(getMid())
    #
    #     def push(heap, num):
    #         heapq.heappush(heap, num)
    #         if heap == maxHeap:
    #             maxSize += 1
    #         else:
    #             minSize += 1
    #
    #     def pop(heap, num):
    #         deleted[num] = True
    #
    #     for i in range(k, len(nums)):
    #         if nums[i] < minHeap[0]:
    #             push(maxHeap, nums[i])
    #         else:
    #             push(minHeap, nums[i])
    #
    #         if nums[i-k] < minHeap[0]:
    #             pop(maxHeap, nums[i-k])
    #         else:
    #             pop(minHeap, nums[i-k])
    #         shift()
    #         ans.append(getMid())
    #     return ans