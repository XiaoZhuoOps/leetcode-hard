package algo.doublePointer;

import java.util.Arrays;
import java.util.PriorityQueue;

public class lc870 {
}
class Solution {
    //田忌赛马
    public int[] advantageCount(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length];
        PriorityQueue<int[]> pq = new PriorityQueue<>((int[] o1, int[] o2) -> o2[1] - o1[1]);
        for (int i = 0; i < nums2.length; i++) {
            pq.offer(new int[]{i,nums2[i]});
        }
        Arrays.sort(nums1);
        int left = 0, right = nums1.length-1;
        while (!pq.isEmpty()) {
            int[] max = pq.poll();
            if (nums1[right] > max[1]) {
                res[max[0]] = nums1[right];
                right--;
            } else {
                res[max[0]] = nums1[left];
                left++;
            }
        }
        return res;
    }
}
