package basic.graph;

import basic.DS.Graph.Node;
import basic.DS.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class lc207 {
}
class Solution207 {
    boolean[] vis;
    List<Integer> path = new ArrayList<>(); //记录一次路径
    boolean hasCircle;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //1、建图
        Graph graph = new Graph(numCourses);
        for (int[] edge : prerequisites) {
            graph.nodes[edge[0]].addAdj(graph.nodes[edge[1]]);
        }
        //2、遍历
        vis = new boolean[numCourses];
        for (Node node : graph.nodes) {
            dfs(node);
            if (hasCircle) break;
        }
        return hasCircle;
    }
    void dfs(Node node) {
        if (path.contains(node.val)) {
            hasCircle = true;
            return;
        }
        if (vis[node.val]) return;
        vis[node.val] = true;
        path.add(node.val);
        for (Node adj : node.adjs) {
            dfs(adj);
        }
        path.remove(path.size()-1);
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
