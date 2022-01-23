package hot100;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class lc139 {
    public boolean wordBreak_dp(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
    /**
     * 记忆化dfs
     */
    int[] dp;
    public boolean wordBreak_dfs(String s, List<String> wordDict) {
        this.dp = new int[s.length()+1];
        Arrays.fill(dp,-1);
        return dfs(0, s, wordDict);
    }
    boolean dfs(int i, String s, List<String> wordDict) {
        if (dp[i] != -1) return dp[i] == 1;
        if (i == s.length()) return true;
        for (int j = i+1; j <= s.length(); j++) {
            if (wordDict.contains(s.substring(i,j)) && dfs(j, s, wordDict)) {
                dp[i] = 1;
                return true;
            }
        }
        dp[i] = 0;
        return false;
    }
}
