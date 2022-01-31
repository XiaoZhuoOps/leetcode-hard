package algo.bfs;

import java.util.List;
import java.util.Queue;
import java.util.ArrayList;
import java.util.LinkedList;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
}
/*
 * def BFS()
 * queue.offer(root)
 * while(!queue){
 *      for(int i=0;i<queue.size();i++){
 *          TreeNode curNode = queue.poll();
 *          for(TreeNode node:curNode.childs){
 *              queue.offer(node);
 *              }
 *          }     
 * }
 */
public class BFS0403 {
    public ListNode[] listOfDepth(TreeNode tree) {

        List<ListNode> listNodes = new ArrayList<>();
        Queue<TreeNode> queueNodes = new LinkedList<>();
        queueNodes.offer(tree);

        while (!queueNodes.isEmpty()) {
            ListNode headNode = new ListNode(queueNodes.peek().val);
            listNodes.add(headNode);

            for (int i = 0; i < queueNodes.size(); i++) {
                TreeNode curNode = queueNodes.poll();
                if (curNode.left != null) {
                    queueNodes.offer(curNode.left);
                    ListNode nextHeadNode = new ListNode(curNode.left.val);
                    headNode.next = nextHeadNode;
                    headNode = nextHeadNode;
                }
                if (curNode.right != null){
                    queueNodes.offer(curNode.right);
                    ListNode nextHeadNode = new ListNode(curNode.right.val);
                    headNode.next = nextHeadNode;
                    headNode = nextHeadNode;
                }
            }
        }
        return (ListNode[]) listNodes.toArray();
    }
}
