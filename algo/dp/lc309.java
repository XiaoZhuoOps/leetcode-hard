package algo.dp;

public class lc309 {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        int len = prices.length;
        int a = -prices[0];
        int b = 0;
        int c = 0;
        for (int i = 1; i < len; ++i) {
            int an = Math.max(a, c - prices[i]);
            int bn = a + prices[i];
            int cn = Math.max(b, c);
            a = an;
            b = bn;
            c = cn;
        }
        return Math.max(b, c);
    }
}

