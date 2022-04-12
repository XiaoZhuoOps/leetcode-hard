package LCP.LCP288;

import java.util.PriorityQueue;

class Solution {
    public int maximumProduct(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num : nums) pq.offer(num);
        for (int i = 0; i < k; i++) {
            Integer poll = pq.poll();
            pq.offer(poll+1);
        }
        long ans = 1;
        while (!pq.isEmpty()) {
            ans *= (pq.poll());
        }
        return (int)(ans % (10^9+7));
    }
}