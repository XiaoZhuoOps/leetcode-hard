package basic.trackBack;

import java.util.ArrayList;
import java.util.List;

public class trackBack0808 {

    int count = 0;
    List<List<Integer>> res = new ArrayList<List<Integer>>();

    public List<List<Integer>> subsets(int[] nums)  {
        List<Integer> list = new ArrayList<Integer>();
        subset(nums,nums.length, list);
        //res.add(new ArrayList<Integer>());
        return res;
    }

    public void subset(int[] nums, int size, List<Integer> list) {
        //排序去重
        ArrayList<Integer> li = new ArrayList<Integer>(list);
        //Collections.sort(list);
        res.add(li);

        for(int num:nums){
            if(list.contains(num)||(!list.isEmpty()&&num<list.get(list.size()-1))) continue;
            else {
                list.add(num);
                count++;
                subset(nums, size, list);
                list.remove(list.size()-1);
                count--;
            }
        }
    }
}
