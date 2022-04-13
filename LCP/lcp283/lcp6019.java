package LCP.lcp283;

import java.util.LinkedList;
import java.util.List;

public class lcp6019 {
    //[31,97561,97561,97561,97561,97561,97561,97561,97561]
    public List<Integer> replaceNonCoprimes(int[] nums) {
        List<Integer> list = new LinkedList<>();
        for (int num : nums) list.add(num);
        int i = 1, a = -1, b = -1;
        for (; i < list.size(); i++) {
            a = list.get(i-1); b = list.get(i);
            if (feihuzhi(a, b)) {
                list.set(i - 1, (int) lcm(a, b));
                list.remove(i);
                if (i > 1) i -= 2;
                else i--;
            }
        }
        return list;
    }
    boolean feihuzhi(int a, int b) {
        return gcd(a, b) > 1;
    }

    long gcd(long a, long b){  //最大公约数
        return a % b != 0 ? gcd(b, a % b) : b;
    }

    long lcm(long a, long b){  //最小公倍数
        return a * b / gcd(a, b);
    }
}
