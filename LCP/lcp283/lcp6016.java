package LCP.lcp283;

import java.util.ArrayList;
import java.util.List;

public class lcp6016 {
    public List<String> cellsInRange(String s) {
        char a = s.charAt(0), b = s.charAt(3), c = s.charAt(1), d = s.charAt(4);
        List<String> ans = new ArrayList<>();
        for (char chc = a; chc <= b; chc++) {
            for (char chr = c; chr <= d; chr++) {
                ans.add("" + chc + chr);
            }
        }
        return ans;
    }
}
