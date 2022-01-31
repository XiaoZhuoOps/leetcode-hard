package algo.bfs;

import java.util.HashMap;
import java.util.Stack;

/**
 * dp算法+DFS
 *
 * 状态：根节点的位置、以及是否被选择
 * 选择：最大的组合
 * dp[r][s]：根节点为r，选择状态为s的树的最大值
 * 转移方程：
 * 转移方程重构：
 * dp[r][1] 选择 hashMap1
 * dp[r][0] 不选择 hashMap2
 * dp[r][1] = r.val + dp[r.left][0] + dp[r.right][0];
 * dp[r][0] = Math.max(
 *                 (dp[r.left][1] + dp[r.right][1]),
 *                 (dp[r.left][0] + dp[r.right][1]),
 *                 (dp[r.left][1] + dp[r.right][0]),
 *
 *         );
 *
 * 如何保存索引为TreeNode的Int数组？
 * 空节点？ getOrDefault
 */

public class DP337 {
    public int rob(TreeNode root) {
        HashMap<TreeNode, Integer> hmY = new HashMap<>();
        HashMap<TreeNode, Integer> hmN = new HashMap<>();
        tra(root,hmY,hmN);
        return Math.max(hmY.getOrDefault(root,0),hmN.getOrDefault(root,0));
    }

    public void tra(TreeNode r, HashMap<TreeNode, Integer> hmY, HashMap<TreeNode, Integer> hmN){
        if(r == null) return;
        tra(r.left, hmY, hmN);
        tra(r.right, hmY, hmN);
        hmY.put(r,r.val+hmN.getOrDefault(r.left,0)+hmN.getOrDefault(r.right,0));
        hmN.put(r,
                Math.max(hmY.getOrDefault(r.left,0),hmN.getOrDefault(r.left,0))+
                Math.max(hmY.getOrDefault(r.right,0),hmN.getOrDefault(r.right,0))
        );
    }

    /**
     * stack遍历版本
     * 一直向右遍历、访问并将左节点放入栈中，直到遇到叶子节点，弹出最后一个左节点，重复此过程，直到栈为空。
     */

    public int rob2(TreeNode root) {
        HashMap<TreeNode, Integer> hmY = new HashMap<>();
        HashMap<TreeNode, Integer> hmN = new HashMap<>();
        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> visit = new Stack<>();

        stack.push(root);
        TreeNode node;

        while(!stack.isEmpty()){
            node = stack.pop();
            while(node!=null){
                visit.push(node);
                if(node.left != null) stack.push(node.left);
                node = node.right;
            }
        }

        while(!visit.isEmpty()){
            node = visit.pop();
            hmY.put(node,node.val+hmN.getOrDefault(node.left,0)+hmN.getOrDefault(node.right,0));
            hmN.put(node, Math.max(hmY.getOrDefault(node.left,0),hmN.getOrDefault(node.left,0))+
                    Math.max(hmY.getOrDefault(node.right,0),hmN.getOrDefault(node.right,0))
            );
        }
        return Math.max(hmY.getOrDefault(root,0),hmN.getOrDefault(root,0));
    }

}


