package algo.DS.Heap;

// 大顶堆
public class BinaryHeap {
    int[] hp;
    int size;

    public BinaryHeap(int cap) {
        this.hp = new int[cap+1]; //0位置不用
        this.size = 0;
    }

    int parent(int cur) {
        return cur / 2;
    }

    // 下标从开始
    int left(int cur) {
        return cur * 2;
    }

    int right(int cur) {
        return cur * 2 + 1;
    }

    void exch(int a, int b) {
        int tmp = hp[a];
        hp[a] = hp[b];
        hp[b] = tmp;
    }

    //复杂度 O(logn) == 树的高度
    void up(int cur) {
        while (1 < cur && hp[cur / 2] < hp[cur]) {
            exch(cur, cur / 2);
            cur = cur / 2;
        }
    }

    //复杂度 O(logn) == 树的高度
    void down(int cur) {
        //子孩子存在
        while (2 * cur <= size) {
            int t = cur * 2;
            //右孩子存在且大于左孩子
            if (t + 1 <= size && hp[t + 1] > hp[t]) {
                t++;
            }
            if (hp[t] <= hp[cur]) break;
            //若孩子大于父亲
            exch(cur, t);
            cur = t;
        }
    }

    void insert(int num) {
        //假定容量充足
        hp[this.size++] = num;
        up(this.size);
    }

    int pop() {
        int res = hp[1];
        //交换第一个和最后一个位置的元素
        exch(1, size);
        hp[size] = -1;
        size--;
        //下沉
        down(1);
        //返回第一个元素
        return res;
    }
}
