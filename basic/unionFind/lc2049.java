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
            map.put(i, cur);
        }

        sizes = new int[parents.length];
//        calcSize(root);
//
//        dfs(root);
        return num;
    }
}