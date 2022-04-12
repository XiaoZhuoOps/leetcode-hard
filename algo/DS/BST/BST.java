package algo.DS.BST;

class TreeNode{
    Integer val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}

public class BST {
    TreeNode rootNode;

    public BST(int val) {
        rootNode = new TreeNode(0);
    }

    TreeNode searchBST(TreeNode root, int target) {
        if (root == null) {
            return null;
        }
        // 去左⼦树搜索
        if (root.val > target) {
            return searchBST(root.left, target);
        }
        // 去右⼦树搜索
        if (root.val < target) {
            return searchBST(root.right, target);
        }
        return root;
    }

    TreeNode insertIntoBST(TreeNode root, int val) {
        // 找到空位置插⼊新节点
        if (root == null) return new TreeNode(val);
        // if (root.val == val)
        // BST 中⼀般不会插⼊已存在元素
        if (root.val < val)
            root.right = insertIntoBST(root.right, val);
        if (root.val > val)
            root.left = insertIntoBST(root.left, val);
        return root;
    }

    TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        if (root.val == key) {
            // 这两个 if 把情况 1 和 2 都正确处理了
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;
            // 处理情况 3
            // 获得右⼦树最⼩的节点
            TreeNode minNode = getMin(root.right);
            // 删除右⼦树最⼩的节点
            root.right = deleteNode(root.right, minNode.val);
            // ⽤右⼦树最⼩的节点替换 root 节点
            minNode.left = root.left;
            minNode.right = root.right;
            root = minNode;
        } else if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else if (root.val < key) {
            root.right = deleteNode(root.right, key);
        }
        return root;
    }

    TreeNode getMin(TreeNode node) {
        // BST 最左边的就是最⼩的
        while (node.left != null) node = node.left;
        return node;
    }

    boolean isSameBST(TreeNode r1, TreeNode r2){
        if(r1.val == null && r2.val == null) return true;
        if(r1.val == null || r2.val == null) return false;
        if(!r1.val.equals(r2.val)) return false;
        return isSameBST(r1.left,r2.left) && isSameBST(r1.right,r2.right);
    }

    int min = Integer.MIN_VALUE;
    int max = Integer.MAX_VALUE;

    //反向思考
    boolean isBST(TreeNode root, int min, int max){
        //base case
        if(root == null) return true;
        if(root.val < min || max < root.val) return false;
        return isBST(root.left, min, root.val) && isBST(root.right, root.val, max);
    }
}
