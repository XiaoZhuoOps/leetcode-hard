package algo.bst;

import algo.DS.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class lc95 {
    public List<TreeNode> generateTrees(int n) {
        return gen(1,n);
    }
    List<TreeNode> gen(int s, int e) {
        if (s > e) {
            List<TreeNode> nodes = new ArrayList<>();
            nodes.add(null);
            return nodes;
        }
        ArrayList<TreeNode> res = new ArrayList<>();

        for (int i = s; i <= e; i++) {
            for (TreeNode left : gen(s, i-1)) {
                for (TreeNode right : gen(i+1, e)) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    res.add(root);
                }
            }
        }
        return res;
    }
}
