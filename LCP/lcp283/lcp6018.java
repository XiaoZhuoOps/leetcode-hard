package LCP.lcp283;

import algo.DS.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class lcp6018 {
    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer, TreeNode> map = new HashMap<>();
        TreeNode root = null, par = null;
        for (int[] node : descriptions) {
            map.put(node[1], new TreeNode(node[1]));
        }
        for (int[] node : descriptions) {
            if (map.get(node[0]) == null) {
                root = new TreeNode(node[0]);
                map.put(node[0], root);
            }
            par = map.get(node[0]);
            if (node[2] == 1) {
                par.left = map.get(node[1]);
            } else {
                par.right = map.get(node[1]);
            }
        }
        return root;
    }
}
