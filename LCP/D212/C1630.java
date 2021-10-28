package LCP.D212;


/**
 * step1 建模 验证 优化
 * step2 框架 变量 伪代码 子问题
 * step3 变量生命周期 数据结构API
 * step4
 *      error1
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class C1630 {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        ArrayList<Boolean> res = new ArrayList<>();
        //traverse
        for(int i = 0; i < l.length; i++){
            int left = l[i], right = r[i];
            //copyOfRange [)
            int[] ints = Arrays.copyOfRange(nums, left, right+1);
            Arrays.sort(ints);
            //check
            int d = ints[1] - ints[0];
            boolean f = true;
            for (int j = 2; j < ints.length; j++) {
                if(ints[j] - ints[j-1] != d){
                    f = false;
                    break;
                }
            }
            res.add(f);
        }
        return res;
    }
}
