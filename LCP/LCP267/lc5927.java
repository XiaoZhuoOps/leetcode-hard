package LCP.LCP267;

public class lc5927 {

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

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Solution {
    public ListNode reverseEvenLengthGroups(ListNode head) {
        int cap = 2, len = 1;
        ListNode pre = head, suc, left = head.next, right = head.next;

        while (right != null) {
            if (len == cap) {
                if(cap%2 == 0) {
                    suc = right.next;
                    right.next = null;
                    rev(left);
                    pre.next = right;
                    left.next = suc;

                    pre = left;
                    left = suc;
                    right = left;
                } else {
                    pre = right;
                    left = right.next;
                    right = left;
                }
                cap++;
                len = 1;
            }
            if(right == null) break;
            right = right.next;
            len++;
        }
        if (len%2==1) {
            left = rev(left);
            pre.next = left;
        }
        return head;
    }

    ListNode rev(ListNode left) {
        if (left == null || left.next == null) return left;
        ListNode rev = rev(left.next);
        left.next.next = left;
        left.next = null;
        return rev;
    }

}
