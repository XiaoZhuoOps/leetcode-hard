package offer;

import java.util.ArrayList;
import java.util.List;

/**
 * step1
 *      preTravers 回溯算法
 * step2
 *      update add remove check
 * step3
 *      注意递归算法的结构性
 *          enter -> add -> check -> remove -> exit
 */
public class O34 {

    List<List<Integer>> res;
    int target;
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        res = new ArrayList<>();
        int sum = 0;
        ArrayList<Integer> path = new ArrayList<>();
        this.target = target;
        preT(root,path,sum);
        return res;
    }

    void preT(TreeNode root, List<Integer> path, int sum){
        if(root == null) return;
        //add
        sum+=root.val;
        path.add(root.val);
        //check
        if(root.left == null && root.right == null) {
            if(sum == target) res.add(new ArrayList<>(path));
        }
        else {
            preT(root.left, path, sum);
            preT(root.right, path, sum);
        }
        //remove
        sum-=root.val;
        path.remove(path.size()-1);
    }
}
