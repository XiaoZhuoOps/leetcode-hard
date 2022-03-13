package algo.dp;

public class lc97 {
    public static void main(String[] args) {
        new lc97().isInterleave("aabc", "abad", "aabadabc");
    }
    public boolean isInterleave(String s1, String s2, String s3) {
        int l1 = s1.length(), l2 = s2.length(), l3 = s3.length();
        if (l1+l2 != l3) return false;
        boolean[][] dp = new boolean[l1+1][l2+1];
        dp[0][0] = true;
        for (int i = 1; i < l1+1; i++) {
            if (s3.charAt(i-1) == s1.charAt(i-1)) dp[i][0] = dp[i-1][0];
            else break;
        }
        for (int i = 1; i < l2+1; i++) {
            if (s3.charAt(i-1) == s2.charAt(i-1)) dp[0][i] = dp[0][i-1];
            else break;
        }
        for (int i = 1; i < l1+1; i++) {
            for (int j = 1; j < l2+1; j++) {
                if(s3.charAt(i+j-1) == s1.charAt(i-1)) dp[i][j] = dp[i-1][j]; //dp[0][j]
                else if(s3.charAt(i+j-1) == s2.charAt(j-1)) dp[i][j] = dp[i][j-1]; //dp[i][0]
            }
        }
        return dp[l1][l2];
    }
}