package basic.ds;

public class maxHeap {
    //variable
    int cap;
    int size;
    int[] nums;

    //constructor
    public maxHeap(int cap){
        this.size = 1;
        this.cap = cap;
        nums = new int[this.cap + 1];
    }

    //api
    public boolean insert(int num) {
        if (size < cap) {
            return false;
        }
        nums[size++] = num;
        up(size);
        return true;
    }

    //上浮
    private void up(int cur) {
        while (1 < cur && nums[cur/2] < nums[cur]) {
            swap(cur/2, cur);
            cur = cur/2;
        }
    }

    //下沉
    private void down(int cur) {
        while (2*cur <= size) {
            int bigger = 2*cur;
            if (bigger+1 <= size && nums[bigger+1] > nums[bigger]) {
                bigger++;
            }
            swap(cur, bigger);
            cur = bigger;
        }
    }

    private void swap(int par, int cur) {
        int temp = nums[par];
        nums[par] = nums[cur];
        nums[cur] = temp;
    }
}
