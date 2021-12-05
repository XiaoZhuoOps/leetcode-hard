package basic.DS;

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
    public int insert(int num) {
        if (size < cap) {
            return -1;
        }
        nums[size++] = num;
        up(size);
        return num;
    }

    public int delete() {
        if (size <= 0) return -1;
        int top = nums[1];
        nums[1] = nums[size];
        down(1);
        return top;
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
        int bci = 2*cur;
        while (bci <= size) {
            if (bci + 1 <= size && nums[bci+1] > nums[bci]) {
                bci++;
            }
            if (nums[bci] > nums[cur]) {
                swap(bci, cur);
                cur = bci;
            } else {
                break;
            }
        }
    }

    private void swap(int par, int cur) {
        int temp = nums[par];
        nums[par] = nums[cur];
        nums[cur] = temp;
    }
}
