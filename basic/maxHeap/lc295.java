package basic.maxHeap;

import java.util.PriorityQueue;

public class lc295 {
}
class MedianFinder {
    //用堆来保证有序性
    PriorityQueue<Integer> maxq;
    PriorityQueue<Integer> minq;
    public MedianFinder() {
        maxq = new PriorityQueue<>((o1,o2) -> o2-o1);
        minq = new PriorityQueue<>();
    }

    public void addNum(int num) {
        int b = (minq.peek() != null) ? minq.peek() : Integer.MAX_VALUE;
        if (num <= b) {
            maxq.offer(num);
        } else {
            minq.offer(num);
        }
        if (maxq.size() > minq.size() + 1) minq.offer(maxq.poll());
        else if (minq.size() > maxq.size() + 1) maxq.offer(minq.poll());
    }

    public double findMedian() {
        if (maxq.size() > minq.size()) return maxq.peek();
        else if (maxq.size() < minq.size()) return minq.peek();
        else if (maxq.isEmpty()){
            return 0;
        } else {
            return ((double) maxq.peek() + (double) minq.peek()) / 2;
        }
    }
}
