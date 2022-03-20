package LCP.LCP285;

import java.util.Arrays;
import java.util.List;

/**
 * [0,0,0,0,1,1,0,0,1,2,3,1]
 * [0,0,0,0,1,1,0,0,1,2,3,1]
 *
 * [0,0,0,0,0,0,0,0,1,1,1,0]
 * [0,0,0,0,0,0,0,0,1,1,1,0]
 *
 * 89
 * [3,2,28,1,7,1,16,7,3,13,3,5]
 * [4,3,0,2,8,2,17,8,4,14,4,6]
 * [21,3,0,2,8,2,17,8,4,14,4,6]
 */
public class L3 {
    int[] aliceArrows;
    int max = -1;
    int[] res;
    public int[] maximumBobPoints(int numArrows, int[] aliceArrows) {
        this.aliceArrows = aliceArrows;
        dfs(numArrows, 0, 0, new int[12]);
        return res;
    }
    void dfs(int arrows, int index, int score, int[] path) {
        if (arrows == 0 || index == 12) {
            if (score > max) {
                max = score;
                res = Arrays.copyOf(path, 12);
                res[0] += arrows;
            }
            return;
        }
        if (arrows > aliceArrows[index]) {
            path[index] = aliceArrows[index]+1;
            dfs(arrows-aliceArrows[index]-1, index+1, score+index, path);
            path[index] = 0;
        }
        dfs(arrows, index+1, score, path);
    }
}
