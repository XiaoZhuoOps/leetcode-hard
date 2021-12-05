package basic.hashMap;

/* 
思路 后序遍历
伪代码
*/


import basic.DS.TreeNode;

public class O27 {
    public TreeNode mirrorTree(TreeNode root) {
        if(root == null) return null;
        TreeNode lch = mirrorTree(root.left);
        TreeNode rch = mirrorTree(root.right);
        TreeNode temp = lch;
        root.left = root.right;
        root.right = temp;
        return root;
    }   
}
