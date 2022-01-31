package lianfang;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Q2 {
    public static void main(String[] args) {
    }
}
//最小堆
class MinHeap{
    List<Integer> nums;
    int size;
    public MinHeap(int n) {
        this.size = 0;
        this.nums = new ArrayList<>();
    }
    int poll() throws Exception {
        if (this.size <= 0) {
            throw new Exception("minHeap is null");
        }
        swap(0, this.size-1);
        //shiftDown
        int p = 0;
        while (p < size) {
            int lch = 2*p+1, rch = 2*p+2;
            int min = 0;
            if (lch < size && nums.get(lch) < nums.get(p)) {
                min = lch;
            }
            if (rch < size && nums.get(rch) < nums.get(min)){
                min = rch;
            }
            swap(p, min);
            p = min;
        }
        int res = nums.get(size-1);
        size--;
        return res;
    }
    void insert(int num) {
        nums.add(num);
        this.size++;
        int cur = this.size-1, p = (cur-1)/2;
        while (nums.get(p) > nums.get(cur)) {
            swap(cur, p);
            cur = p;
            p = (cur-1)/2;
        }
    }

    void swap(int cur, int p) {
        int temp = nums.get(cur);
        nums.set(cur, nums.get(p));
        nums.set(p, temp);
    }
}
