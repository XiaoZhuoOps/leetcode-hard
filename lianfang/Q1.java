package lianfang;

import algo.DS.ListNode;
/**
 * 给一个有序数组（单调不减），和一个数x，找到数组中第一个大于等于>=x的数，返回它的下标
 */
public class Q1 {
    int findX(int[] nums, int target) {
        int left = 0, right = nums.length-1;
        if (target > nums[right]) return -1;
        while (left < right) {
            int mid = (left +  right) >> 1;
            if (target <= nums[mid]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,4};
        System.out.println(new Q1().findX(nums, 2));
        System.out.println(new Q1().findX(nums, 3));
        System.out.println(new Q1().findX(nums, 5));
    }
}
