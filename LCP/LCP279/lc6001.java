package LCP.LCP279;

import java.util.ArrayList;
import java.util.List;

public class lc6001 {
    public long smallestNumber(long num) {
        char[] chars = String.valueOf(Math.abs(num)).toCharArray();
        List<Character> list = new ArrayList<>();
        for (char ch : chars) list.add(ch);

        if (num == 0) return 0;
        else if (num > 0) {
            list.sort((c1,c2)->{return c1-c2;});
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i) > '0')  {
                    Character remove = list.remove(i);
                    list.add(0,remove);
                    break;
                }
            }
            StringBuffer sb = new StringBuffer();
            for (Character ch : list) {
                sb.append(ch);
            }
            return Long.parseLong(sb.toString());
        } else {
            list.sort((c1,c2)->{return c2-c1;});
            StringBuffer sb = new StringBuffer();
            for (Character ch : list) {
                sb.append(ch);
            }
            return -1*Long.parseLong(sb.toString());
        }
    }
}
