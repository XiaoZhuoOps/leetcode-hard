package algo.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 1、
 * 2、
 * 3、
 */
public class lc399 {
    public static void main(String[] args) {

    }
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        //1 建图
        int index = 0; //节点的索引
        HashMap<String, Integer> map = new HashMap<>();
        for (List<String> list : equations) {
            if (!map.containsKey(list.get(0))) map.put(list.get(0), index++);
            if (!map.containsKey(list.get(1))) map.put(list.get(1), index++);
        }
        List<Edge>[] graph = new List[index];
        for (int i = 0; i < index; i++) graph[i] = new ArrayList<>();
        for (int i = 0; i < equations.size(); i++) {
            int a = map.get(equations.get(i).get(0)), b = map.get(equations.get(i).get(1));
            double value = values[i];
            graph[a].add(new Edge(b, value));
            graph[b].add(new Edge(a, 1/value));
        }
        //2 dfs
        double[] ans = new double[queries.size()];
        int i = 0;
        for (List<String> list : queries) {
            String curStr = list.get(0), tarStr = list.get(1);
            res = -1.0;
            vis = new boolean[index];
            if (map.containsKey(curStr) && map.containsKey(tarStr)){
                System.out.println("im here");
                dfs(graph, map.get(curStr), map.get(tarStr), 1);
            }
            ans[i++] = res;
        }
        return ans;
    }
    boolean[] vis;
    double res;
    void dfs(List<Edge>[] graph, int cur, int tar, double path) {
        vis[cur] = true;
        if (cur == tar) {
            res = path;
            return;
        }
        for (Edge edge : graph[cur]) {
            if (vis[cur]) continue;
            dfs(graph, edge.node, tar, path * edge.value);
        }
    }
}
class Edge{
    int node;
    double value;
    public Edge(int node, double value) {
        this.node = node;
        this.value = value;
    }
}
