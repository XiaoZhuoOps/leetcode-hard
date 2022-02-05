package algo.DS.BST;

class TreeNode{
    Integer v;
    TreeNode lch;
    TreeNode rch;
}

public class BST {

    boolean isSameBST(TreeNode r1, TreeNode r2){
        if(r1.v == null && r2.v == null) return true;
        if(r1.v == null || r2.v == null) return false;
        if(!r1.v.equals(r2.v)) return false;
        return isSameBST(r1.lch,r2.lch) && isSameBST(r1.rch,r2.rch);
    }

    int min = Integer.MIN_VALUE;
    int max = Integer.MAX_VALUE;

    //反向思考
    boolean isBST(TreeNode root, int min, int max){
        //base case
        if(root == null) return true;
        if(root.v < min || max < root.v) return false;
        return isBST(root.lch, min, root.v) && isBST(root.rch, root.v, max);
    }
}
