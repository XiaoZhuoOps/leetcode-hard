package LCP.LCP270;

import algo.DS.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class lc5944 {

    Map<Integer, Integer> isAncient = new HashMap<>();
    TreeNode lowestAncient;
    int startValue, destValue;
    List<String> pathS = new ArrayList<>(), pathE = new ArrayList<>();

    public String getDirections(TreeNode root, int startValue, int destValue) {
        this.startValue = startValue;
        this.destValue = destValue;

        calcAncient(root);
        lowestAncient(root);
        path(lowestAncient, new ArrayList<>());

        StringBuilder sb = new StringBuilder();
        for (String str : pathS) {
            sb.append("U");
        }
        for (String str : pathE) {
            sb.append(str);
        }
        return sb.toString();
    }

    void path(TreeNode root, List<String> path) {
        if (root == null) return;
        if (root.val == startValue) {
            pathS = new ArrayList<>(path);
        }
        if (root.val == destValue) {
            pathE = new ArrayList<>(path);
        }
        if (root.left != null) {
            path.add("L");
            path(root.left, path);
            path.remove(path.size()-1);
        }

        if (root.right != null) {
            path.add("R");
            path(root.right, path);
            path.remove(path.size()-1);
        }
    }

    void calcAncient(TreeNode root){
        if (root == null) return;
        calcAncient(root.left);
        calcAncient(root.right);
        isAncient.put(root.val, ((root.left == null) ? 0 : isAncient.get(root.left.val))
                                + ((root.right == null) ? 0 : isAncient.get(root.right.val))
                                + ((root.val == startValue || root.val == destValue) ? 1 : 0));
    }

    void lowestAncient(TreeNode root) {
        if (root == null) return;
        if (isAncient.get(root.val) == 2 &&
                (root.left == null || isAncient.get(root.left.val) < 2) &&
                (root.right == null || isAncient.get(root.right.val) < 2)
        ) {
            lowestAncient = root;
            return;
        }
        lowestAncient(root.left);
        lowestAncient(root.right);
    }
}
