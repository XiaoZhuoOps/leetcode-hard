package basic.graph.mst;

import basic.DS.Graph.UnionFind;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class lcp1489 {
    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
        List<List<Integer>> res = new ArrayList<List<Integer>>(2);
        res.add(new ArrayList<>());
        res.add(new ArrayList<>());
        int[][] newEdges = new int[edges.length][4];
        //重新构造edge来记录原始下标
        for (int i = 0; i < edges.length; i++) {
            newEdges[i][0] = edges[i][0];
            newEdges[i][1] = edges[i][1];
            newEdges[i][2] = edges[i][2];
            newEdges[i][3] = i; // origin index
        }
        //1、kruskal
        Arrays.sort(newEdges, (e1, e2) -> e1[2] - e2[2]);
        int minWeightSum = 0;
        UnionFind uf = new UnionFind(n);
        for (int[] edge : newEdges) {
            if (uf.connected(edge[0], edge[1])) continue;
            uf.union(edge[0], edge[1]);
            minWeightSum += edge[2];
        }
        //2、for each edge, decide if
        for (int i = 0; i < newEdges.length; i++) {
            //2.1 select an edge, add it firstly and decide if weightSum > minWeightSum
            int weightSum1 = 0;
            uf = new UnionFind(n);
            uf.union(newEdges[i][0], newEdges[i][1]);
            weightSum1 += newEdges[i][2];
            for (int j = 0; j < newEdges.length; j++) {
                if (uf.connected(newEdges[j][0], newEdges[j][1])) continue;
                uf.union(newEdges[j][0], newEdges[j][1]);
                weightSum1 += newEdges[j][2];
            }
            if (weightSum1 > minWeightSum) continue;

            //2.2 remove edge and decide if weightSum2 == weightSum
            int weightSum2 = 0;
            uf = new UnionFind(n);
            for (int j = 0; j < newEdges.length; j++) {
                if (j == i) continue;
                if (uf.connected(newEdges[j][0], newEdges[j][1])) continue;
                uf.union(newEdges[j][0], newEdges[j][1]);
                weightSum2 += newEdges[j][2];
            }
            if (uf.count != 1 || weightSum2 != minWeightSum) {
                res.get(0).add(newEdges[i][3]);
            } else res.get(1).add(newEdges[i][3]);
        }
        return res;
    }
}
