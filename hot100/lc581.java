package hot100;

public class lc581 {
    public int findUnsortedSubarray(int[] nums) {
        //数组分成三段,第一段升序(0,left]、第二段无序(left, right)、第三段升序[right,len)
        int left = 0, right = nums.length-1;
        //1、首先分别从头（从尾）遍历，找到尽可能长的第一段升序数组和第三段升序数组。
        while (left < right && nums[left] <= nums[left+1]) left++;
        while (left < right && nums[right-1] <= nums[right]) right--;
        //2、找出第二段无序数组的最大和最小值
        //特别地，nums[left] <= nums[right]必须成立，所以这里将min的初始值设置为nums[right],目的是包含left+1==right的情况。
        int min = nums[right], max = nums[left];
        for (int i = left + 1; i < right; i++) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }
        //3、在h[left] <= min(left, right) <= max(left, right) <= h[right]条件没有满足前一直循环。
        while ((0 <= left && nums[left] > min)
                || (right < nums.length && nums[right] < max)) {
            while (0 <= left && nums[left] > min) {
                //扩大第二段无序数组的范围，注意min,max的变化
                //因为nums[left] > nums[left+1] >= min，所以left左移不会改变min，但是有可能改变max，整个要注意
                max = Math.max(max, nums[left]);
                left--;
            }
            while (right < nums.length && nums[right] < max) {
                min = Math.min(min, nums[right]);
                right++;
            }
        }
        return right - left + 1;
    }
}
