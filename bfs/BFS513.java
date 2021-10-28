package bfs;

import java.util.LinkedList;
import java.util.Queue;

//找出一棵树最深的左节点
public class BFS513 {
    public int findBottomLeftValue(TreeNode root) {
        TreeNode res = null;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            res = queue.peek();
            for(int i=0;i<queue.size();i++){
                TreeNode cur = queue.poll();
                if(cur.left!=null) queue.offer(cur.left);
                if(cur.right!=null) queue.offer(cur.right);
            }
        }
        return (res == null)?0:res.val;
    }
}
