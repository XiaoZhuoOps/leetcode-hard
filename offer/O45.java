package offer;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * 最高位选剩余元素中首位最小的 首位相同 比较下一位
 * 如何排序？
 *      按首位大小排序 首位相同 判断下一位 不改变元素本身
 *      if a + b < b + a then a < b
 *      compare(int a, int b){}
 * O(logn)
 * 30 + 34 = 3034
 *      str1.compareTo(str2)
 * ----------------------
 * error [3,30,34,5,9]
 * error [121,12]
 * -----------------------
 * 自定义排序规则 匿名内部类
 */
public class O45 {
    public String minNumber(int[] nums) {
        Integer[] integers = Arrays.stream(nums).boxed().toArray(Integer[]::new);
        Arrays.sort(integers, new Comparator<Integer>(){
            public int compare(Integer a, Integer b){
                String stra = "" + a + b;
                String strb = "" + b + a;
                return stra.compareTo(strb);
            }
        });
        StringBuilder ans = new StringBuilder();
        for(Integer i:integers){
            ans.append(i);
        }
        return ans.toString();
    }
}
