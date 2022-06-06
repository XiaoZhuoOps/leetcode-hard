# 给你一个整数数组 nums 和两个整数 k 和 t 。请你判断是否存在 两个不同下标 i 和 j，使得 abs(nums[i] - nums[j]) <= t ，同时又满足 abs(i - j) <= k 。
# 如果存在则返回 true，不存在返回 false。
from bisect import bisect


class Solution:
    def containsNearbyAlmostDuplicate(self, nums: List[int], k: int, t: int) -> bool:
        i, j = 0, 1
        while j <= i+k:
            for m in range(i, j):
                if abs(nums[m]-nums[j]) <= t:
                    return True
            j += 1
        i += 1
        while j < len(nums):
            for m in range(i, j):
                if abs(nums[m]-nums[j]) <= t:
                    return True
            i += 1
            j += 1
        return False

    # 
    # 
    def containsNearbyAlmostDuplicate(self, nums: List[int], k: int, t: int) -> bool:
        from sortedcontainers import SortedSet
        st = SortedSet()
        st.remove()
        st.add()
        bisect.bisect_left(st, nums[j])
        i, j, ls = 0, 0, len(nums)
        while j < ls:
            st.remove(nums[i-1])
            # 
            bisect.bisect_left(st, nums[j])
            st.add(nums[j])
            j += 1
            i += 1
        return False