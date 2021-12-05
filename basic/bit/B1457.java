package basic.bit;


import basic.DS.TreeNode;

/*
    1思路 dfs回溯+异或判断
    2伪代码
    3实现
    4debug
 */
public class B1457 {
    int res;
    public int pseudoPalindromicPaths (TreeNode root) {
        res = 0;
        dfs(root, 0);
        return res;
    }

    void dfs(TreeNode root, int temp){
        temp^=(1<<root.val);
        //base
        if(root.left == null && root.right == null){
            //judge
            if(temp == 0|| ((temp&(temp-1))==0)) res++;
        }
        //dfs
        if(root.left!=null) dfs(root.left, temp);
        if(root.right!=null) dfs(root.right, temp);
    }
}
