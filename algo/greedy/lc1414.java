package algo.greedy;

import java.util.ArrayList;

public class lc1414 {
    public int findMinFibonacciNumbers(int k) {
        ArrayList<Integer> list = new ArrayList<>();
        int a = 1, b = 1;
        while (a <= k) {
            list.add(a);
            int c = a + b;
            a = b;
            b = c;
        }
        int res = 0;
        for (int i = list.size() - 1; 0 <= i && 0 < k; i--) {
            if (list.get(i) <= k) {
                k -= list.get(i);
                res++;
            }
        }
        return res;
    }
}
