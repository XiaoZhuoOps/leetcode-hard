package basic.bin;

public class lc375 {
    int[][] r;

    public int getMoneyAmount(int n) {
        r = new int[n][n];
        return f(1, n);
    }

    int f(int i, int j) {
        if (i >= j) return 0;
        if (r[i - 1][j - 1] != 0) return r[i - 1][j - 1];
        int min = Integer.MAX_VALUE;
        for (int k = i; k <= j; k++) {
            min = Math.min(min, Math.max(f(i, k - 1), f(k + 1, j)) + k);
        }
        r[i - 1][j - 1] = min;
        return min;
    }
}
