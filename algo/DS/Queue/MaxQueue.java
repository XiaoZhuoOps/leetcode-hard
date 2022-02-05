package algo.DS.Queue;

import java.util.Deque;
import java.util.Queue;

/**
 * max队列
 */
public class MaxQueue {

    Queue<Integer> queue;
    Deque<Integer> deque;
    public MaxQueue() {
    }

    public int max_value() {
        if(queue.isEmpty()) return -1;
        return deque.getLast();
    }

    public void push_back(int value) {
        queue.offer(value);
        while(0<deque.size() && deque.getLast()<value){
            deque.removeLast();
        }
        deque.offerFirst(value);
    }

    public int pop_front() {
        if (queue.isEmpty())
            return -1;
        int val = queue.poll();
        if(val == deque.peekFirst()){
            deque.removeFirst();
        }
        return val;
    }
}
