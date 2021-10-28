package Dp;

public class UpStack {
    public int[] LeastMaxNum(int[] nums){
        int[] dp = new int[nums.length];
        dp[nums.length-1] = nums.length;
        for (int i = nums.length-2; 0 <= i; i--) {
            int j = i+1;
            while(j<nums.length){
                if(nums[i] >= nums[j]){
                    j = dp[j];
                }
                else {
                    dp[i] = j;
                    break;
                }
            }
            if(j==nums.length) dp[i] = nums.length;
        }
        return dp;
    }
}
