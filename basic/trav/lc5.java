package basic.trav;

public class lc5 {
}

class Solution {
    int start = 0, end = 0, max = -1;

    public String longestPalindrome(String s) {
        char[] chars = s.toCharArray();
        for (int k = 0; k < chars.length; k++) {
            extend1(chars, k);
            extend2(chars, k);
        }
        return s.substring(start, end+1);
    }

    void extend1(char[] chars, int k) {
        int len = 1;
        int i = k-1, j = k+1;
        for (; 0 <= i && j < chars.length; i--, j++) {
            if (chars[i] == chars[j]) {
                len+=2;
            } else {
                break;
            }
        }
        if (len > max) {
            max = len;
            start = i+1;
            end = j-1;
        }
    }

    void extend2(char[] chars, int k) {
        int len = 0;
        int i = k, j = k+1;
        for (; 0 <= i && j < chars.length; i--, j++) {
            if (chars[i] == chars[j]) {
                len+=2;
            } else {
                break;
            }
        }
        if (len > max) {
            max = len;
            start = i+1;
            end = j-1;
        }
    }
}
