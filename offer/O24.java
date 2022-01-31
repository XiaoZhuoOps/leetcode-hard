package offer;

import algo.DS.ListNode;

public class O24 {
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
    public ListNode reverseList2(ListNode head) {
        //base
        if(head == null || head.next == null) return head;
        ListNode second = head.next;
        ListNode tailer = reverseList(second);
        second.next = head;
        head.next = null;
        return tailer;
    }
}
