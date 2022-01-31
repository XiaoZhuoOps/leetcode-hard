package algo.graph.CircleAndTopo;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class CircleAndTopo {
    boolean[] vis;
    List<Integer> path = new ArrayList<>(); //记录一次路径
    boolean hasCircle;
    Stack<Integer> stack = new Stack<>();
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        //1、建图
        Graph graph = new Graph(numCourses);
        for (int[] edge : prerequisites) {
            graph.nodes[edge[1]].addAdj(graph.nodes[edge[0]]);
        }
        //2、遍历
        vis = new boolean[numCourses];
        for (Node node : graph.nodes) {
            dfs(node);
            if (hasCircle) {
                return new int[]{};
            }
        }
        int len = stack.size();
        int[] res = new int[len];
        for(int i = 0; i < len; i++) {
            res[i] = stack.pop();
        }
        return res;
    }
    void dfs(Node node) {
        //当前节点到根节点的路径
        if (path.contains(node.val)) {
            hasCircle = true;
            return;
        }
        if (vis[node.val]) return;
        vis[node.val] = true;
        //加入路径
        path.add(node.val);
        //dfs访问子节点
        for (Node adj : node.adjs) {
            dfs(adj);
        }
        //子节点全部访问完成，加入topo队列
        stack.push(node.val);
        //从路径中删去这个节点
        path.remove(path.size()-1);
    }
}
class Node{
    int val;
    public List<Node> adjs = new ArrayList<>();
    public Node(int val) {
        this.val = val;
    }
    public void addAdj(Node node) {
        this.adjs.add(node);
    }
}
class Graph{
    Node[] nodes;
    public Graph(int n){
        nodes = new Node[n];
        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = new Node(i);
        }
    }
}
