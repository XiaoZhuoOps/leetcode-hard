package basic.graph.mst;
import basic.DS.Graph.Edge;
import basic.DS.Graph.Graph;
import basic.DS.Graph.Node;

import java.util.PriorityQueue;

//最小生成树算法
public class Prim {
    int weightSum = 0;
    public Prim(Graph graph) {
        boolean[] inMST = new boolean[graph.n];
        PriorityQueue<basic.DS.Graph.Edge> pq =
                new PriorityQueue<>((e1,e2)->{return e1.weight-e2.weight;});
        for (basic.DS.Graph.Edge edge : graph.edges[0]){
            pq.offer(edge);
        }
        while (!pq.isEmpty()) {
            Edge minEdge = pq.poll();
            if (inMST[minEdge.to.index]) continue; //avoid circle
            weightSum += minEdge.weight;
            for (Edge edge : graph.edges[minEdge.to.index]) {
                if (inMST[edge.to.index]) continue;
                pq.offer(edge);
            }
        }
    }
    public int minWeight() {
        return weightSum;
    }
}

