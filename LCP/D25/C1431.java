package LCP.D25;

import java.util.ArrayList;
import java.util.List;

/**
 * step1
 *      先找max 遍历判断
 * step2
 *
 * step1
 * step1
 */
public class C1431 {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = 1;
        List<Boolean> res = new ArrayList<>();
        for (int candy : candies) {
            if (max < candy) max = candy;
        }
        for (int candy: candies) {
            if(max <= candy+extraCandies){
                res.add(Boolean.TRUE);
            }else res.add(Boolean.FALSE);
        }
        return res;
    }
}
