package basic.graph;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

class Node implements Comparable<Node>{
    int i;
    double path;
    public Node(int i, double path) {
        this.i = i;
        this.path = path;
    }

    @Override
    public int compareTo(Node o) {
        return (this.path > o.path) ? -1 : 1;
    }
}
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
            if (sp[curNode.i] > 0) continue;
            sp[curNode.i] = curNode.path;
            for (Node node : nodes(curNode)) {
                if (sp[node.i] > 0) continue;
                pq.offer(node);
            }
        }
        return sp[end];
    }
    List<Node> nodes(Node cur) {
        List<Node> nodes = new ArrayList<>();
        for (int i = 0; i < edges.length; i++) {
            if (edges[i][0] == cur.i) {
                nodes.add(new Node(edges[i][1], cur.path*succProb[i]));
            } else if (edges[i][1] == cur.i) {
                nodes.add(new Node(edges[i][0], cur.path*succProb[i]));
            }
        }
        return nodes;
    }
}
