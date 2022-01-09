package LCP.LCP274;

import java.util.Arrays;

public class lcp5969 {
}
class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);
        for (int as : asteroids) {
            if (mass < as) return false;
            mass += as;
        }
        return true;
    }
}