package basic.monoHeap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class lcp373 {
}
class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<Integer[]> pq = new PriorityQueue<>((a1,a2) -> nums1[a1[0]]+nums2[a1[1]]-nums1[a2[0]]-nums2[a2[1]]); //int[iu,iv]
        List<List<Integer>> ans = new ArrayList<>(); //[u,v]

        pq.offer(new Integer[]{0,0});
        for (int i = 0; i < k; i++) {
            Integer[] poll = pq.poll();
            if (poll == null) break;
            ans.add(new ArrayList<>(Arrays.asList(nums1[poll[0]], nums2[poll[1]])));
            if (poll[0] + 1 < nums1.length){
                pq.offer(new Integer[]{poll[0] + 1, poll[1]});
            }
            if (poll[1] + 1 < nums2.length){
                pq.offer(new Integer[]{poll[0], poll[1] + 1});
            }
        }
        return ans;
    }
}