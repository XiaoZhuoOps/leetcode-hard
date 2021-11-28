package LCP.LCP264;

public class lcp2047 {
    public int countValidWords(String sentence) {
        String[] split = sentence.split(" ");
        int num = 0;
        for (String str : split) {
            if (str.isEmpty())  continue;
            int a = 0, b = 0;
            int i = 0;
            for (; i < str.length(); i++) {
                char ch = str.charAt(i);
                if (!isWord(ch)) break;
                if (ch == '-') {
                    if (a == 1) break;
                    if (0 > i - 1 || i + 1 >= str.length()
                        || !isLetter(str.charAt(i-1))
                        || !isLetter(str.charAt(i+1))
                        ) break;
                    a++;
                }
                if (ch == '.' || ch == ',' || ch == '!') {
                    if (b == 1) break;
                    if (i != str.length()-1) break;
                    b++;
                }
            }
            if (i == str.length()) {
                num++;
            }
        }
        return num;
    }

    boolean isWord(char ch) {
        return ('a' <= ch && ch <= 'z')
                || ch == '-'
                || ch == '/'
                || ch == '.' || ch == ',' || ch == '!';
    }

    boolean isLetter(char ch) {
        return ('a' <= ch && ch <= 'z');
    }
}
