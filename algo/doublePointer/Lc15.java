package algo.doublePointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lc15 {
    public List<List<Integer>> threeSum(int[] nums) {
        int len = nums.length, left = 0, right = 0, target = 0;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        for (int cur = 0; cur < len; cur++) {
            if (0 < cur && nums[cur] == nums[cur-1]) continue;
            target = -1 * nums[cur];
            left = cur + 1;
            right = len - 1;
            while (left < right) {
                if (nums[left] + nums[right] == target) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[cur]); temp.add(nums[left]); temp.add(nums[right]);
                    ans.add(temp);
                    left++;
                    right--;
                    while(left < right && nums[left] == nums[left-1]) left++;
                    while(left < right && nums[right] == nums[right+1]) right--;
                }
                else if (nums[left] + nums[right] < target) left++;
                else right--;
            }
        }
        return ans;
    }
}
