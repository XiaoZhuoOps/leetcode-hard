package offer;


import java.util.ArrayList;
import java.util.List;

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
}

/**
 * 树的递归
 */
public class O26 {

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if(A == null || B == null) return false;
        return preTra2(A,B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    boolean preTra2(TreeNode ra, TreeNode rb){
        if(rb == null) return true;
        else if(ra == null) return false;
        return (ra.val == rb.val) && preTra2(ra.left,rb.left) && preTra2(ra.right, rb.right);
    }
}
