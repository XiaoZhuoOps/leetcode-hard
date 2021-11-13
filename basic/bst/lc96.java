package basic.bst;

class Solution {
    int[] r = new int[19];
    public int numTrees(int n) {
        if (n <= 1) return 1;
        if (r[n-1] != 0) return r[n-1];
        int res = 0;
        for (int i = 1; i <= n; i++) {
            res += (numTrees(i-1) * numTrees(n-i));
        }
        r[n-1] = res;
        return res;
    }
}
