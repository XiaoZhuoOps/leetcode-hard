package basic.bin;

/**
 *
 */
public class lc875 {
    int[] ps;
    int h;
    public int minEatingSpeed(int[] piles, int h) {
        this.ps = piles;
        this.h = h;

        int left = 1, right = 1000000000;
        while (left < right) {
            int mid = (left + right) / 2;
            if (check(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    boolean check(int mid){
        int sum = 0;
        for (int p: ps) {
            if (p % mid != 0) sum++;
            sum += (p / mid);
        }
        return sum <= h;
    }
}
