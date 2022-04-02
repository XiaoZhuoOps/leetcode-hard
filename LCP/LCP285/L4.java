package LCP.LCP285;
class L4 {
    public static void main(String[] args) {
        new L4().isMatch("aa", "a");
    }
    char[] ss;
    char[] ps;
    public boolean isMatch(String s, String p) {
        this.ss = s.toCharArray();
        this.ps = p.toCharArray();
        int ls = s.length(), lp = p.length();
        boolean[][] dp = new boolean[ls+1][lp+1];
        dp[0][0] = true;

        for (int i = 1; i <= ls; i++) {
            for (int j = 1; j <= lp; j++) {
                dp[i][j] = (dp[i-1][j-1] && match(i-1,j-1)) ||
                        (dp[i-1][j] && ps[j-1] == '*' && match(i-1, j-2)) ||
                        (dp[i][j-1] && ps[j-1] == '*') ||
                        (0 <= j-2 && dp[i][j-2] && ps[j-1] == '*');
            }
        }
        return dp[ls][lp];
    }
    boolean match(int i, int j) {
        if (0 > i || 0 > j) return false;
        if (ss[i] == ps[j]) {
            return true;
        } else if (ps[j] == '.') {
            return true;
        } else if (ps[j] == '*' && match(i,j-1)){
            return true;
        } else return false;
    }
}

