package algo.graph.mst;


import java.util.Arrays;
import java.util.Comparator;

public class lcp1584 {
}
class UF{
    
}
class Edge{
    int i;
    int j;
    int len;
    public Edge(int i, int j, int len) {
        this.i = i;
        this.j = j;
        this.len = len;
    }
}
class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        int len = (n*(n-1))/2;
        Edge[] edges = new Edge[len];
        int k = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                int edge = (Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]));
                edges[k++] = new Edge(i,j,edge);
            }
        }
        Arrays.sort(edges, new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.len - o2.len;
            }
        });
        for (Edge edge : edges) {

        }
        return 1;
    }
}