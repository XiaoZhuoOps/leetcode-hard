package offer;

/* 
    思路 两次遍历
    伪代码
*/
public class O22 {
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode cur = head;
        int num = 0;
        while(cur!=null){
            num++;
            cur = cur.next;
        }
        ListNode cur = head;
        num-=(k-1);
        for(int i = 0; i+1 < num; i++){
            cur = cur.next;
        }
        return cur;
    }
}
