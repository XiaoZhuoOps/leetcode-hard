package offer;

import basic.DS.ListNode;

public class O24 {
}
class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode cur = head, next = head.next, tmp;
        head.next = null;
        while (next != null) {
            tmp = next.next;
            next.next = cur;
            cur = next;
            next = tmp;
        }
        return cur;
    }
}
