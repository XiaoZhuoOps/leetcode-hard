package hot100;

import algo.DS.ListNode;

public class lcp148 {
    public ListNode sortList(ListNode head) {
        //1、find the midNode
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode right = slow.next;
        slow.next = null;
        ListNode left = head;
        //2、sort
        ListNode leftNode = sortList(left);
        ListNode rightNode = sortList(right);
        //3、merge
        ListNode dumpy = new ListNode(0);
        ListNode cur = dumpy, up = leftNode, down = rightNode;
        while (up != null && down != null) {
            if (up.val < down.val) {
                cur.next = up;
                up = up.next;
            } else {
                cur.next = down;
                down = down.next;
            }
            cur = cur.next;
        }
        if (up != null) cur.next = up;
        if (down != null) cur.next = down;
        return dumpy.next;
    }
}
