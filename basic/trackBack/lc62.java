package basic.trackBack;



public class lc62 {

}


class Solution1 {
    public int smallestEqual(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (j == nums[i]) return i;
            else {
                j = (j == 9) ? 0 : j + 1;
            }
        }
        return -1;
    }
}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class ListNode {
    int val;
    ListNode next;
}

class Solution2 {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int lastIndex = -1, curIndex = 1, mind = Integer.MAX_VALUE, sum = 0;
        ListNode pre = head, next = head.next;

        while (next != null && next.next != null) {
            if ((pre.val < next.val && next.val > next.next.val) ||
                    (pre.val > next.val && next.val < next.next.val)) {
                if (lastIndex == -1) {
                    lastIndex = curIndex;
                } else {
                    int d = curIndex - lastIndex;
                    sum += d;
                    if (d < mind) mind = d;
                    lastIndex = curIndex;
                }
            }
            curIndex++;
            next = next.next;
            pre = pre.next;
        }
        if (mind == Integer.MAX_VALUE) {
            return new int[]{-1, -1};
        }
        return new int[]{mind, sum};
    }
}

class Solution3 {
    int[] nums;
    int[] operations = new int[]{1, 2, 3};
    int start, goal;
    int res = Integer.MAX_VALUE;

    public int minimumOperations(int[] nums, int start, int goal) {
        this.nums = nums;
        this.start = start;
        this.goal = goal;
        dfs(start, 0);
        return (res == Integer.MAX_VALUE) ? -1 : res;
    }

    void dfs(int cur, int op) {
        if (op != 0 && cur == start) return;
        if (cur == goal && op < res) {
            res = op;
            return;
        }
        if (0 > cur || cur > 1000) {
            return;
        }
        for (int num : nums) {
            for (int operation : operations) {
                dfs(calcu(cur, num, operation), op+1);
            }
        }
    }

     int calcu(int cur, int num, int operation) {
        switch (operation) {
            case 1: {
                return cur + num;
            }
            case 2:{
                return cur - num;
            }
            case 3:{
                return cur ^ num;
            }
        }
        return cur;
    }
}


