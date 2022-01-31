package hot100;

import algo.DS.ListNode;

public class lc2 {
}


class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode la, lb;
        if (len(l1) > len(l2)) {
            la = l1;
            lb = l2;
        } else {
            la = l2;
            lb = l1;
        }

        ListNode ca = la, cb = lb;
        int add = 0, sum = 0;
        while (ca != null && cb != null) {
            sum = ca.val + cb.val + add;
            ca.val = sum % 10;
            add = sum / 10;

            ca = ca.next;
            cb = cb.next;
        }
        while (ca != null) {
            sum = ca.val + add;
            ca.val = sum % 10;
            add = sum / 10;

            ca = ca.next;
        }
        if (add != 0) {
            ca = new ListNode(add);
        }
        return la;
    }

    int len(ListNode l1) {
        int len = 0;
        ListNode cur = l1;
        while (cur != null) {
            len++;
            cur = cur.next;
        }
        return len;
    }
}
