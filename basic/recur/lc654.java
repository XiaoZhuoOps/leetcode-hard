package basic.recur;

import basic.DS.TreeNode;

public class lc654 {
}
class Solution {
    int[] nums;
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        this.nums = nums;
        return recur(0, nums.length-1);
    }
    TreeNode recur(int a, int b) {
        if (b > a) return null;
        int index = maxIndex(a,b);
        TreeNode root = new TreeNode(nums[index]);
        root.left = recur(a,index-1);
        root.right = recur(index+1, b);
        return root;
    }
    int maxIndex(int a, int b) {
        int index = 0, max = Integer.MIN_VALUE;
        for (int i = a; i <= b; i++) {
            if (max < nums[i]) {
                max = nums[i];
                index = i;
            }
        }
        return index;
    }
}
