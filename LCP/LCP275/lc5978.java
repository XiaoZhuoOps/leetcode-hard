package LCP.LCP275;

import java.util.HashSet;

public class lc5978 {
}

class Solution {
    public int wordCount(String[] startWords, String[] targetWords) {
        HashSet<Integer> set = new HashSet<>();
        int res = 0;
        for (String str : startWords) {
            set.add(toInt(str));
        }
        for (String str : targetWords) {
            int num = toInt(str);
            for (char ch : str.toCharArray()) {
                if(set.contains(num ^ (1 << (ch - 'a')))) {
                    res++;
                    break;
                }
            }
        }
        return res;
    }
    int toInt(String str) {
        int ans = 0;
        for (char ch : str.toCharArray()) {
            ans |= (1 << (ch - 'a'));
        }
        return ans;
    }
}