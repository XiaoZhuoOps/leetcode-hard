package basic.recur;

import basic.DS.TreeNode;
import org.omg.CORBA.MARSHAL;

public class lc1373 {
}
class Solution {
    int max = Integer.MIN_VALUE;
    public int maxSumBST(TreeNode root) {
        recur(root);
        return max;
    }
    int[] recur(TreeNode root) {
        if (root == null) {
            return new int[]{1,Integer.MAX_VALUE,Integer.MIN_VALUE,0};
        }
        int[] left = recur(root.left);
        int[] right = recur(root.right);
        if (left[0] == 0 || right[0] == 0 || left[2] >= root.val || right[1] <= root.val)  {
            return new int[]{0,0,0,0};
        } else {
            max = Math.max(max, root.val+left[3]+right[3]);
            return new int[]{1,(left[1] == Integer.MAX_VALUE)?root.val:left[1], (right[2]==Integer.MIN_VALUE)?root.val:right[2],root.val+left[3]+right[3]};
        }
    }
}
