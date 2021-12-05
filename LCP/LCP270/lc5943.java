package LCP.LCP270;

import basic.DS.ListNode;

public class lc5943 {
    public ListNode deleteMiddle(ListNode head) {
        if (head.next == null) return null;
        ListNode cur = head, last = head;
        int step = 0;
        while (cur != null) {
            cur = cur.next;
            step++;
        }

        cur = head.next;
        for (int i = 1; i < step/2; i++) {
            last = last.next;
            cur = cur.next;
        }

        last.next = cur.next;
        return head;
    }
}
