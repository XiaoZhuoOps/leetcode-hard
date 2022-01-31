package algo.trackBack;
/*
    典型的排列组合问题 -> 回溯
    path
    check
 */
import java.util.ArrayList;
import java.util.List;

public class T78 {
    List<List<Integer>> res;
    public List<List<Integer>> subsets(int[] nums) {
        //init
        res = new ArrayList<>();
        tb(nums, new ArrayList<>(), Integer.MIN_VALUE);
        return res;
    }

    void tb(int[] nums, List<Integer> path, int cur){
        //base
        res.add(new ArrayList<>(path));
        //recur
        for(int num:nums){
            if(num <= cur) continue;
            path.add(num);
            tb(nums, path, num);
            path.remove(path.size()-1);
        }
    }
}
