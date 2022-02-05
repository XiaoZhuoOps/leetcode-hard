package algo.DS.Heap;

public class BinaryHeap {
    int[] hp;
    int cur;
    int n;

    int parent(int cur) {
        return cur / 2;
    }

    int left(int cur) {
        return cur * 2;
    }

    int right(int cur) {
        return cur * 2 + 1;
    }

    void exch(int a, int b) {
    }

    ;

    //复杂度 O(logn) == 树的高度
    void swim(int cur) {
        while (1 < cur && hp[cur / 2] < hp[cur]) {
            exch(cur, cur / 2);
            cur = cur / 2;
        }
    }

    //复杂度 O(logn) == 树的高度
    void sink(int cur) {
        while (2 * cur <= n) {
            int t = cur * 2;
            if (t + 1 <= n && hp[t + 1] > hp[t]) {
                t++;
            }
            if (hp[t] <= hp[cur]) break;
            exch(cur, t);
            cur = t;
        }
    }

    int delMax() {
        int res = hp[1];
        exch(1, n);
        hp[n] = -1;
        n--;
        sink(1);
        return res;
    }
}
