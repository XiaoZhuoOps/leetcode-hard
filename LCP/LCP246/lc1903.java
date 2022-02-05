package LCP.LCP246;

public class lc1903 {
    public String largestOddNumber(String num) {
        for (int i = num.length()-1; 0 <= i; i--) {
            if (isOdd(num.charAt(i))) return num.substring(0,i+1);
        }
        return "";
    }

    boolean isOdd(char charAt) {
        return ((charAt - '0') & 1) == 1;
    }
}
