package basic.monoQueue;

import java.util.LinkedList;

public class lc239 {
}
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length-k+1];
        MonoQueue mq = new MonoQueue();
        for (int i = 0; i < k; i++) {
            mq.offer(nums[i]);
        }
        for (int i = 0; i < res.length; i++) {
            res[i] = mq.max();
            mq.poll(nums[i]);
            if (i + 1 < res.length){
                mq.offer(nums[i + k]);
            }
        }
        return res;
    }
}

//单调队列
class MonoQueue {
    LinkedList<Integer> queue;
    public MonoQueue(){
        queue = new LinkedList<>();
    }
    void offer(int num) {
        while (!queue.isEmpty() && queue.getFirst() < num) {
            queue.removeFirst();
        }
        queue.addFirst(num);
    }
    void poll(int num) {
        if (!queue.isEmpty() && num == queue.getLast()) {
            queue.removeLast();
        }
    }
    int max() {
        return queue.getLast();
    }
}
