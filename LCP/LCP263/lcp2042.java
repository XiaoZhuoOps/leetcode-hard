package LCP.LCP263;

public class lcp2042 {
    public boolean areNumbersAscending(String s) {
        int last = 0, now = 0;
        int i = 0;
        char[] chars = s.toCharArray();
        while (i < chars.length) {
            while (i < chars.length && isNum(chars[i])) {
                now = 10*now + toNum(chars[i]);
                i++;
            }
            if (now <= last) return false;
            else {
                last = now;
                now = 0;
            }
        }
        return true;
    }

    boolean isNum(char ch) {
        return '0' <= ch && ch <= '9';
    }

    int toNum(char ch) {
        return ch - '0';
    }
}
