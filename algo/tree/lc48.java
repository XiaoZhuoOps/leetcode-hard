package algo.tree;

import algo.DS.TreeNode;
import java.util.*;
public class lc48 {

    StringBuilder sb;
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        this.sb = new StringBuilder();
        preTra(root);
        return sb.toString();
    }
    void preTra(TreeNode root) {
        if (root == null) {
            sb.append("N,");
            return;
        }
        sb.append(root.val).append(",");
        preTra(root.left);
        preTra(root.right);
    }

    public TreeNode deserialize(String data){
        String[] split = data.split(",");
        List<String> list = new LinkedList<>(Arrays.asList(split));
//        List<Integer> collect = Stream.of(split).map(Integer::parseInt).collect(Collectors.toList());
        return deserialize0(list);
    }
    TreeNode deserialize0(List<String> list) {
        if (list.isEmpty()) return null;
        if (list.get(0).equals("N")) {
            list.remove(0);
            return null;
        }
        int remove = Integer.parseInt(list.remove(0));
        TreeNode root = new TreeNode(remove);
        root.left = deserialize0(list);
        root.right = deserialize0(list);
        return root;
    }
    // Decodes your encoded data to tree.
    public TreeNode deserialize_2(String data) {
        String[] split = data.split(",");
        if (split.length == 1) return null;

        WrapTreeNode root = new WrapTreeNode(new TreeNode(Integer.parseInt(split[0])),
                false, false);
        Stack<WrapTreeNode> stack = new Stack<>();
        stack.push(root);
        for (int i = 1; i < split.length; i++) {
            if (!"N".equals(split[i])) {
                stack.push(new WrapTreeNode(new TreeNode(Integer.parseInt(split[i])),
                        false, false));
            } else {
                stack.push(new WrapTreeNode(null, true, true)); //叶子节点也算是构建完成的节点，相当于递归基
                do {
                    WrapTreeNode cur = stack.pop(); //表示已构建完成的节点
                    if (stack.isEmpty()) break;
                    WrapTreeNode top = stack.peek(); //尚未构建完成的节点
                    if (!top.hasLch) {
                        top.tn.left = cur.tn;
                        top.hasLch = true;
                    } else {
                        top.tn.right = cur.tn;
                        top.hasRch = true;
                    }
                } while (stack.peek().has2Ch()); //不断弹出所有构建完成的节点
            }
        }
        return root.tn;
    }
}
class WrapTreeNode{
    TreeNode tn;
    public boolean hasLch;
    public boolean hasRch;
    public boolean has2Ch(){
        return hasLch && hasRch;
    }
    public WrapTreeNode(TreeNode tn,boolean hasLch,boolean hasRch){
        this.tn = tn;
        this.hasLch = hasLch;
        this.hasRch = hasRch;
    }
}
