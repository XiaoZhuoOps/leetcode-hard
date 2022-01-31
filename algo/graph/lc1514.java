package algo.graph;

import algo.DS.Graph.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class lc1514 {
    int[][] edges;
    double[] succProb;
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        this.edges = edges;
        this.succProb = succProb;
        double[] sp = new double[n];
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 1));
        while (!pq.isEmpty()) {
            Node curNode = pq.poll();
            if (sp[curNode.index] > 0) continue;
            sp[curNode.index] = curNode.path;
            for (Node node : nodes(curNode)) {
                if (sp[node.index] > 0) continue;
                pq.offer(node);
            }
        }
        return sp[end];
    }
    List<Node> nodes(Node cur) {
        List<Node> nodes = new ArrayList<>();
        for (int i = 0; i < edges.length; i++) {
            if (edges[i][0] == cur.index) {
                nodes.add(new Node(edges[i][1], cur.path*succProb[i]));
            } else if (edges[i][1] == cur.index) {
                nodes.add(new Node(edges[i][0], cur.path*succProb[i]));
            }
        }
        return nodes;
    }
}
