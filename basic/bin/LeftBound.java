package basic.bin;

public class LeftBound {
    /*
     * 返回满足条件的左侧节点
     */
    int left_bound2(int[] nums, int target) {
        int left = 0, right = nums.length, mid = 0;
        while (left < right) {
            mid = (left + right) / 2;
            if (nums[mid] == target) {
                right = mid; //只要找到target就一直设置为right,故最终的左侧节点一定是right
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid;
            }
        }
        // left == right
        return right;
    }

    /**
     * 减而治之：
     * 令l、r分别为nums的左右边界，在保证 l ≤ bound ≤ r 前提下，不断以二分的方式缩小区间[l,r] ，直到l == r，
     * 此时若 target == nums[l]，l是左边界；否则说明nums中不存在target，返回-1。
     */
    int left_bound(int[] nums, int target) {
        if (nums.length == 0) return -1;

        int left = 0, right = nums.length - 1, mid = 0;
        while (left < right) {
            mid = (left + right) >> 1;
            if (nums[mid] > target) {
                right = mid; //right = mid - 1 可能会造成right < left 而越界
            } else if (nums[mid] < target) {
                left = mid + 1; //left = mid 可能会造成死循环
            } else {
                right = mid; //找左边界
            }
        }
        //退出时必有left==right
        return (nums[right] == target) ? right : -1;
    }

    int right_bound(int[] nums, int target) {
        if (nums.length == 0) return -1;

        int left = 0, right = nums.length - 1, mid = 0;
        mid = (left + right + 1) >> 1;
        while (left < right) {
            if (nums[mid] < target) {
                left = mid; //left = mid + 1 可能会造成right < left 而越界
            } else if (nums[mid] > target) {
                right = mid - 1; //right = mid 可能会造成死循环
            } else {
                left = mid; //找右边界
            }
        }
        //退出时必有left==right
        return (nums[right] == target) ? right : -1;
    }
}

