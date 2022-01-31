package algo.monoHeap;

public class lc2064 {

}

class Solution {
    public int minimizedMaximum(int n, int[] quantities) {
        int left = 1, right = 100000;
        while (left < right) {
            int max = (left + right) >> 1;
            if (needStores(max, quantities) <= n) {
                right = max; //left boundary
            } else {
                left = max + 1;
            }
        }
        return left;
    }

    int needStores(int max, int[] quantities) {
        int needs = 0;
        for (int quantity : quantities) {
            needs += ((quantity % max == 0) ? (quantity / max) : (quantity / max + 1));
        }
        return needs;
    }
}