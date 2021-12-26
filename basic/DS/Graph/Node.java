package basic.DS.Graph;

import java.util.ArrayList;
import java.util.List;

public class Node implements Comparable<Node>{
    public double path;
    public int index;
    public int val;
    public List<Node> adjs = new ArrayList<>();
    public Node(int val) {
        this.val = val;
    }
    public void addAdj(Node node) {
        this.adjs.add(node);
    }
    public Node(double p, double i) {
        this.path = p;
        this.index = (int) i;
    }
    @Override
    public int compareTo(Node o) {
        return (this.path > o.path) ? -1 : 1;
    }
}