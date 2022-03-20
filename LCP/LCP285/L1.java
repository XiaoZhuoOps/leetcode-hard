package LCP.LCP285;

public class L1 {
    public int countHillValley(int[] nums) {
        int len = nums.length, ans = 0;
        for (int i = 1; i < len-1; i++) {
            int leftVal = nums[i-1];
            while (i < len-1 && nums[i+1] == nums[i]) i++;
            if (i == len-1) return ans;
            if (leftVal < nums[i] && nums[i] > nums[i+1]) ans++;
            if (leftVal > nums[i] && nums[i] < nums[i+1]) ans++;
        }
        return ans;
    }
}
