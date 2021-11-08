package LCP.LCP266;

import java.util.HashMap;

class Solution {
    public long countVowels(String word) {
        int[] dp = new int[word.length()];
        int len = word.length();
        long sum = 0;
        dp[len - 1] = (isMeta(word.charAt(len - 1)) ? 1 : 0);
        sum += dp[len-1];
        for (int i = len - 2; 0 <= i; i--) {
            if (isMeta(word.charAt(i))) {
                dp[i] = dp[i+1] + len - i;
            } else {
                dp[i] = dp[i+1];
            }
            sum += dp[i];
        }
        return sum;
    }

    boolean isMeta(char ch) {
        return (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u');
    }


    int min = Integer.MAX_VALUE;
    int n;
    public int minimizedMaximum(int n, int[] quantities) {
        this.n = n;
        int max = Integer.MIN_VALUE;
        int notZero = 0;
        for (int q : quantities) {
            if (q != 0) notZero++;
        }
        helper(0, quantities, max, notZero);
        return min;
    }

    void helper(int i, int[] quantities, int max, int notZero) {
        if (notZero + i > n) {
            return;
        }
        if (i + 1 == n) {
            int num = 0, index = 0;
            for (int j = 0; j < quantities.length; j++) {
                if (quantities[j] != 0) {
                    num++;
                    index = j;
                }
            }
            if (num <= 1) {
                max = Math.max(max, quantities[index]);
                min = Math.min(min, max);
            }
            return;
        }
        for (int j = 0; j < quantities.length; j++) {
            for (int k = 0; k <= quantities[j]; k++) {
                if (quantities[j] != 0 && k == quantities[j]) {
                    notZero--;
                }
                quantities[j] -= k;
                helper(i+1, quantities, Math.max(max, k), notZero);
                quantities[j] += k;
                if (quantities[j] != 0 && k == quantities[j]) {
                    notZero++;
                }
            }
        }
    }

}