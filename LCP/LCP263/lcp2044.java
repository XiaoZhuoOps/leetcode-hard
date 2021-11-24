package LCP.LCP263;

import java.util.HashMap;
import java.util.Map;

public class lcp2044 {
    int[] nums;
    boolean[] selected;
    int select = 0;
    Map<Integer, Integer> map;
    int max = -1;
    public int countMaxOrSubsets(int[] nums) {
        this.nums = nums;
        this.selected = new boolean[nums.length];
        map = new HashMap<>();
        dfs(0,0);
        return map.get(max);
    }

    void dfs(int or, int start) {
        if (select == nums.length) return;
        map.put(or, map.getOrDefault(or,0)+1);
        max = Math.max(max, or);
        for (int i = start; i < nums.length; i++) {
            if (selected[i]) continue;
            selected[i] = true;
            select++;
            dfs(or|nums[i], start+1);
            selected[i] = false;
            select--;
        }
    }
}
