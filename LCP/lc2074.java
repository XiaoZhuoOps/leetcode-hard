package LCP;

public class lc2074 {

}

class ListNode{
    int val;
    ListNode next;
    ListNode() {};
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode reverseEvenLengthGroups(ListNode head) {
        int cap = 2, len = 1;
        ListNode pre = head, suc, left = head.next, right = head.next;

        while (right != null) {
            right = right.next;
            len++;
            if (len == cap) {
                suc = right.next;

                right.next = null;
                rev(left);
                pre.next = right;
                left.next = suc;

                pre = left;
                left = suc;
                right = left;
                cap++;
                len = 1;
            }
        }
        if (len%2==1) {
            rev(left);
        }
        return head;
    }

    ListNode rev(ListNode left) {
        if (left == null) return null;
        ListNode rev = rev(left.next);
        left.next.next = left;
        left.next = null;
        return rev;
    }
}
