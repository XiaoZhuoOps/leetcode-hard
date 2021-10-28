package offer;

/* 
思路 dfs
伪代码 
*/

public class O55 {
    int maxDep;
    public int maxDepth(TreeNode root) {
        maxDep = 0;
        dfs(root, 0);
        return maxDep;
    }

    void dfs(TreeNode root, int depth){
        if(root == null){
            if(maxDep < depth) maxDep = depth;
            return;
        };
        dfs(root.left, depth+1);
        dfs(root.right, depth+1);
    }
}
