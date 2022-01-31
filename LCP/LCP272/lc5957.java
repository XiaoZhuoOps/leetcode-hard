package LCP.LCP272;

import java.util.LinkedList;

class lc5957 {
    public String addSpaces(String s, int[] spaces) {
        StringBuffer sb = new StringBuffer();
        int i = 0, j = 0, len = s.length();
        while (i < len) {
            if (j < spaces.length && i == spaces[j]) {
                sb.append(' ');
                j++;
            }
            sb.append(s.charAt(i));
            i++;
        }
        return sb.toString();
    }
}