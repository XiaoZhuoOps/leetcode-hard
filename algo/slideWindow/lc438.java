package algo.slideWindow;

import java.util.ArrayList;
import java.util.List;

public class lc438 {
    
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int[] nums = new int[26];
        char[] sChars = s.toCharArray();
        char[] pChars = p.toCharArray();
        int pLen = pChars.length, sLen = sChars.length, notZero = 0;
        if (sLen < pLen) return res;

        for (char pChar : pChars) {
            if (nums[pChar - 'a'] == 0) notZero++;
            nums[pChar - 'a']++;
        }
        
        for (int i = 0; i < pLen; i++) {
            if (nums[sChars[i]-'a'] == 0) notZero++;
            nums[sChars[i]-'a']--;
            if (nums[sChars[i]-'a'] == 0) notZero--;
        }
        if (notZero == 0) res.add(0);

        for (int i = pLen; i < sLen; i++) {
            if (nums[sChars[i-pLen]-'a'] == 0) {
                notZero++;
            }
            nums[sChars[i-pLen]-'a']++;
            if (nums[sChars[i-pLen]-'a'] == 0) {
                notZero--;
            }
            if (nums[sChars[i]-'a'] == 0) {
                notZero++;
            }
            nums[sChars[i]-'a']--;
            if (nums[sChars[i]-'a'] == 0) {
                notZero--;
            }
            if (notZero == 0) res.add(i-pLen+1);
        }
        return res;
    }
}
