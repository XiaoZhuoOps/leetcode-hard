package LCP.DCP74;

import java.util.ArrayList;
import java.util.List;

/**
 * "zigfj"
 * "ju"
 *
 * "iekbksds m uuzwxb p m cngsfkjv p zuknqguzvzik"
 * "mp"
 *
 * "fwymvreuftzgrcrxczjacyovduqaiig"
 * "yy"
 *
 */
public class L2 {
    public long maximumSubsequenceCount(String text, String pattern) {
        long ans = 0;
        if (pattern.charAt(0) == pattern.charAt(1)) {
            for (char ch : text.toCharArray()) {
                if (ch == pattern.charAt(0)) ans++;
            }
            ans++;
            return ans * (ans+1) / 2;
        }
        //
        List<Integer> p1 = new ArrayList<>(), p2 = new ArrayList<>();
        char[] chars = text.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == pattern.charAt(0)) p1.add(i);
            if (chars[i] == pattern.charAt(1)) p2.add(i);
        }
        int left = 0, right = 0, len1 = p1.size(), len2 = p2.size();
        while (left < len1 && right < len2) {
            while (right < len2 && p1.get(left) > p2.get(right)) right++;
            ans+=(len2-right);
            left++;
        }
        return ans + Math.max(len1, len2);
    }
}
