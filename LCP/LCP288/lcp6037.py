class Solution:
    def largestInteger(self, num: int) -> int:
        nums1, bits1, nums2, bits2 = [], [], [], []
        bit = 1
        while num > 0:
            a = num % 10
            if a % 2 == 0:
                nums2.append(a)
                bits2.append(bit)
            else:
                nums1.append(a)
                bits1.append(bit)
            num //= 10
            bit *= 10
        sorted(nums1)
        sorted(nums2)
        ans = 0
        for i in range(len(nums1)):
            ans += (nums1[i]*bits1[i])
        for i in range(len(nums2)):
            ans += (nums2[i]*bits2[i])
        return ans