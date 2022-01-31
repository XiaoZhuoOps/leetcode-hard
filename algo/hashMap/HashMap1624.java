package algo.hashMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class HashMap1624 {
    /**
     * hashmap<Sum - nums[i] , n>
     * @param nums
     * @param target
     * @return
     */
    public List<List<Integer>> pairSums(int[] nums, int target) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> a = new ArrayList<>(2);
        int len = nums.length, n = 0;
        for (int i = 0; i < len; i++) {
            if((n = hm.getOrDefault(nums[i], 0))>0){
                a.add(0,target-nums[i]);
                a.add(1,nums[i]);
                ans.add(a); //值传递 所以每次要新建一个list
                hm.put(nums[i], --n);
            }
            else{
                hm.put(target-nums[i], hm.getOrDefault(target-nums[i], 0)+1);
            }
        }
        return ans;
    }
}
