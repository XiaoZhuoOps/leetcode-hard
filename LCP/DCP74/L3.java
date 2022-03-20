package LCP.DCP74;

import java.util.PriorityQueue;

public class L3 {
    public int halveArray(int[] nums) {
        PriorityQueue<Double> pq = new PriorityQueue<Double>(((o1, o2) -> o2.compareTo(o1)));
        double sum = 0, dec = 0; int op = 0;
        for (int num : nums) {
            pq.offer((double) num);
            sum += num;
        }
        while (dec*2 < sum && !pq.isEmpty()) {
            double cur = pq.poll();
            dec += cur/2;
            pq.offer(cur/2);
            op++;
        }
        return op;
    }
}
