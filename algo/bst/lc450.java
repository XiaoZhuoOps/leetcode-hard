package algo.bst;

import algo.DS.TreeNode;

public class lc450 {
}
class Solution {
    //对递归的理解不到位
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (root.val == key) {
            if (root.left == null) {
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }
            TreeNode max = getMax(root.left);
            root.val = max.val;
            root.left = deleteNode(root.left, max.val);
        } else if (root.val < key) {
            root.right = deleteNode(root.right, key);
        } else {
            root.left = deleteNode(root.left, key);
        }
        return root;
    }
    TreeNode getMax(TreeNode root){
        while (root.right != null) {
            root = root.right;
        }
        return root;
    }
}

