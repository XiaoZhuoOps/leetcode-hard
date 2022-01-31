package algo.greedy;

import java.util.PriorityQueue;

//1、典型贪心问题。
//2、假设最多能越过n个台阶，则必然会在台阶差距最大的地方使用梯子，剩下的使用砖头，知道砖头不够为止
//3、pq
public class lcp1642 {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        int needs = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 1; i < heights.length; i++) {
            int diff = heights[i] - heights[i-1];
            if (diff <= 0) continue;
            pq.offer(diff);
            if (pq.size() > ladders) {
                //必须使用砖头了
                needs += pq.poll();
            }
            if (needs > bricks) {
                //砖头不够了
                return i-1;
            }
        }
        return heights.length-1;
    }
}
