package LCP.LCP270;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class lc5942 {
    public int[] findEvenNumbers(int[] digits) {
        int len = digits.length;
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < len; i++) {
            if (digits[i] == 0) continue;
            for (int j = 0; j < len; j++) {
                if (i == j) continue;
                for (int k = 0; k < len; k++) {
                    if (digits[k]%2 == 1 || k == i || k == j) continue;
                    set.add(digits[i]*100 + digits[j]*10 + digits[k]);
                }
            }
        }
        Integer[] sets = set.toArray(new Integer[0]);
        int[] ans = new int[sets.length];
        for (int i = 0; i < sets.length; i++) {
            ans[i] = sets[i];
        }
        Arrays.sort(ans);
        return ans;
    }
}
