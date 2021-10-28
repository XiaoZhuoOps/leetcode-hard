package offer;

public class O67 {
    public int strToInt(String str) {
        if(str == null) return 0;
        if(str.trim().equals("")) return 0;
        int ans = 0;
        int i = 0, sign = 1, len = str.length();
        boolean flag = false;
        if(str.charAt(i) == '+') {
            sign = 1;
            i++;
        }
        else if(str.charAt(i) == '-') {
            sign = -1;
            i++;
        }
        while(i < len && str.charAt(i) <= '9' && '0' <= str.charAt(i)){
            if(ans > Integer.MAX_VALUE/10 || (ans == Integer.MAX_VALUE/10 && str.charAt(i) > 7)) {
                if(sign == 1) return Integer.MAX_VALUE;
                else return Integer.MIN_VALUE;
            }
            ans = ans*10 + str.charAt(i++) - '0';
        }
        return (sign == -1)?(-1*ans):ans;
    }
}
