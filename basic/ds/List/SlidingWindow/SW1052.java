package basic.ds.List.SlidingWindow;

import java.util.ArrayList;
import java.util.List;

public class SW1052 {
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int wl = 0, maxPeople = 0, wr = wl + X - 1, len = customers.length;
        List<Integer> ans = new ArrayList<>();
        // 初始化maxPeople
        for (int i = 0; i < len; i++) {
            if (i < X || grumpy[i] == 0)
                maxPeople += customers[i];
        }
        while (wr + 1 < len) {
            // 更新窗口
            wl++;
            wr = wl + X - 1;
            // 更新结果
            if (grumpy[wl - 1] == 1){
                maxPeople -= customers[wl - 1];
            }
            if (grumpy[wr] == 1){
                maxPeople += customers[wr];
            }
            ans.add(maxPeople);
        }
        for(int a:ans){
            if(maxPeople<a) maxPeople = a;
        }
        return maxPeople;
    }
    public static void main(String[] args){
        int[] customers = new int[]{1,0,1,2,1,1,7,5};
        int[] grumpy = new int[]{0,1,0,1,0,1,0,1};
        int X = 3;
        new SW1052().maxSatisfied(customers, grumpy, X);
    }
}
