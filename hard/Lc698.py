class Solution:
    def canPartitionKSubsets(self, nums: List[int], k: int) -> bool:
        n, m = len(nums), 0
        for num in nums:
            m += num
        dp = [[0 for _ in range(k+1)] for _ in range(1<<n)] 
        map = []
        for i in range(1<<n):
            sum, cur, j = 0, 1, 1
            while cur <= i:
                if i&cur != 0:
                    sum += nums[j-1]
                j += 1
                cur <<= 1
            if sum == (m/k):
                map.append(i)
                dp[i][1] = 1
        
        for j in range(1,k):
            for i in range(1<<n):
                for s in map:
                    if i&s == 0 and dp[i][j] == 1:
                        dp[i|s][j+1] = 1
        return dp[(1<<n)-1][k] == 1