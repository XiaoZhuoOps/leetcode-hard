package basic.LIS;

import java.util.ArrayList;
import java.util.List;

public class lc300 {
}
class Solution {
    public int lengthOfLIS(int[] nums) {
        List<Integer> list = new ArrayList<>(); //长度为i+1的子序列末尾的最小元素
        list.add(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > list.get(list.size()-1)) {
                list.add(nums[i]);
            } else {
                int left = 0, right = list.size()-1;
                while (left < right) {
                    int mid = (left + right) >> 1;
                    if (nums[i] <= list.get(mid)) {
                        right = mid; //查找>=num的最小元素
                    } else {
                        left = mid + 1;
                    }
                }
                list.set(left, nums[i]);
            }
        }
        return list.size();
    }
}
