package hot100;

class t34 {
    public int[] searchRange(int[] nums, int target) {
        return new int[]{left_bound(nums, target), right_bound(nums, target)};
    }

    int left_bound(int[] nums, int target) {
        if (nums.length == 0) return -1;
        
        int left = 0, right = nums.length - 1, mid = 0;
        while(left < right) {
            mid = (left + right) >> 1;
            if (nums[mid] >= target) {
                right = mid;
            }            
            else if (nums[mid] < target) {
                left = mid + 1;
            }
        }
        return (nums[right] == target) ? right : -1;
    }

    int right_bound(int[] nums, int target) {
        
        int left = 0, right = nums.length, mid = 0;
        while(left < right) {
            mid = (left + right) >> 1;
            if (nums[mid] <= target) {
                left = mid + 1;
            }             
            else if (nums[mid] > target) {
                right = mid;
            }
        }
        return (nums[right-1] == target) ? right : -1;
    }
}