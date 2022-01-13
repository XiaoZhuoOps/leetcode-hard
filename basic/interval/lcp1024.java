package basic.interval;

import java.util.Arrays;

/**
 * 1、典型的区间问题 + 贪心问题
 * 2、设区间为[s,e]，先按照s升序排列；要想使用的区间尽可能的少，则每次在满足区间连续的前提下，都必须选取e最大的区间；
 * 3、lastEnd、maxEnd；空间复杂度O(n)
 * 4、嵌套循环；注意边界条件的判断
 */
public class lcp1024 {
    public int videoStitching(int[][] clips, int time) {
        int res = 0;
        Arrays.sort(clips, (c1, c2) -> c1[0] - c2[0]);
        int lastEnd = 0;
        for (int i = 0; i < clips.length; i++) {
            int maxEnd = lastEnd;
            while (i < clips.length && clips[i][0] <= lastEnd) {
                maxEnd = Math.max(maxEnd, clips[i][1]);
                i++;
            }
            if (maxEnd > lastEnd){
                res++;
                lastEnd = maxEnd;
                i--;
            } else {
                //区间不连续
                return -1;
            }
            //提前判断总长度是否满足条件
            if (lastEnd >= time) return res;
        }
        //判断总长度是否满足要求
        return (lastEnd >= time) ? res : -1;
    }
}
