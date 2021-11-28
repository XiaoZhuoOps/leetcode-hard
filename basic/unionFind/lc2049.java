package basic.unionFind;

import basic.ds.TreeNode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class lc2049 {
    public int countHighestScoreNodes(int[] parents) {
        int max = -1, num = 0;
        for (int i = 0; i < parents.length; i++) {
            int product = calcProduct(parents, i);
            if (product < max) {
            } else if (product == max) {
                num++;
            } else {
                max = product;
                num = 1;
            }
        }
        return num;
    }

    int calcProduct(int[] parents, int k) {
        int temp = parents[k];
        parents[k] = -2;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < parents.length; i++) {
            if (i == k) continue;
            int cur = i;
            while (parents[cur] != -1 && parents[parents[cur]] != -2) {
                cur = parents[cur];
            }
            map.put(cur, map.getOrDefault(cur, 0) + 1);
        }
        int product = 1;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            product *= entry.getValue();
        }
        parents[k] = temp;
        return product;
    }
}

class Solution{
    int[] sizes;
    int max = -1, num = 0;
    public int countHighestScoreNodes(int[] parents){
        Map<Integer, TreeNode> map = new HashMap<>();
        TreeNode root = new TreeNode(0);
        map.put(0, root);
        for (int i = 1; i < parents.length; i++) {
            TreeNode cur = new TreeNode(i);
            TreeNode par;
            if (!map.containsKey(parents[i])) {
                par = new TreeNode(parents[i]);
                map.put(parents[i], par);
            } else {
                par = map.get(parents[i]);
            }
            if (par.left == null) par.left = cur;
            else par.right = cur;
            if (!map.containsKey(i)) {
                map.put(i, cur);
            }
        }
        sizes = new int[parents.length];
        calcSize(root);

        dfs(root);
        return num;
    }

    int calcSize(TreeNode root) {
        if (root == null) return 0;
        int num = calcSize(root.left) + calcSize(root.right) + 1;
        sizes[root.val] = num;
        return num;
    }

    void dfs(TreeNode root) {
        if (root == null) return;
        int num1 = (sizes[0] == sizes[root.val]) ? 1 : (sizes[0] - sizes[root.val]);
        int num2 = (root.left == null) ? (1) : (sizes[root.left.val]);
        int num3 = (root.right == null) ? (1) : (sizes[root.right.val]);
        int product = num1 * num2 * num3;
        if (product > max) {
            max = product;
            num = 1;
        } else if (product == max) {
            num++;
        }
        dfs(root.left);
        dfs(root.right);
    }

    public static void main(String[] args) {
        new Solution().countHighestScoreNodes(new int[]{-1,2,0,2,0});
    }
}