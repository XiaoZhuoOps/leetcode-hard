package basic.dfs;
import java.util.HashMap;
import java.util.Stack;

public class Dfs230 {
    // 用栈实现后序遍历
    void postTra(TreeNode node){
        HashMap<TreeNode,Boolean> isVisited = new HashMap<TreeNode,Boolean>();
        Stack<TreeNode> s = new Stack<TreeNode>();
        s.push(node);
        while(!s.empty()){
            node = s.peek();
            if(isVisited.get(node) != true) isVisited.put(node, true);
            else s.pop();
            node = node.right;
            while(node.left!=null){
                node = node.left;
                s.push(node);
            }
        }
    }


    void postTra2(TreeNode node) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        deepTra(node, stack);
        while(stack!=null){
            // visit from leafNode up to RootNode
            node = stack.pop(); //node is deepest in stack, should be firstly visited
            visit(node);
            // if curNode is par.left, traverse par.right
            if(node == stack.peek().left) deepTra(stack.peek().right, stack);
            // else visit par
            // else node = stack.peek();
        }
    }

    void deepTra(TreeNode node, Stack<TreeNode> stack){
        //一直向下遍历子节点，优先左节点，后右节点，直到叶子结点
        while(node!=null){
            stack.push(node);
            if(node.left!=null) node = node.left;
            else node = node.right;
        }
    }

    void midTra(TreeNode node){
        Stack<TreeNode> stack = new Stack<TreeNode>();
        deepLeftTra(node, stack);
        while(stack!=null){
            node = stack.pop();
            visit(node);
            if(node.right!=null) deepLeftTra(node.right, stack);
        }
    }

    void deepLeftTra(TreeNode node, Stack<TreeNode> stack){
        while(node!=null){
            stack.push(node);
            node = node.left;
        }
} 
    void visit(TreeNode node){}

    public int kthSmallest(TreeNode root, int k) {
        return 0;
    }
    
}
