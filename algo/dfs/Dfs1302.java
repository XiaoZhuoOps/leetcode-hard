package algo.dfs;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Dfs1302 {
    /**
     *  dfs(node)
     *      if(!node) return
     *      dfs(node.left)
     *      dfs(node.right)
     */
    int maxDep = 0;
    int Sum = 0;
    public int deepestLeavesSum(TreeNode root) {
        dfs(root,0);
        return Sum;
    }
    // 作为参数传递的条件：1 随着递归层级的变化而变化 2
    public void dfs(TreeNode root, int dep){
        //叶子节点
        if(root.left == null && root.right == null) {
            if(dep > maxDep) {maxDep = dep ; Sum = root.val;}
            else if(dep == maxDep) Sum += root.val;
            return;
        }
        dfs(root.left, dep+1);
        dfs(root.right, dep+1);
    }
}
