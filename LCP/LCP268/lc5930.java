package LCP.LCP268;

public class lc5930 {
}

class Solution {
    public int maxDistance(int[] colors) {
        int max = -1;
        for (int i = 0; i < colors.length; i++) {
            for (int j = i + 1; j < colors.length; j++) {
                if (colors[i] != colors[j]){
                    max = Math.max(max, j-i);
                }
            }
        }
        return max;
    }
}
