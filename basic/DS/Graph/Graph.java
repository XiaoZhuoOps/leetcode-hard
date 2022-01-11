package basic.DS.Graph;


import java.util.LinkedList;
import java.util.List;

//基于邻接表形式的图
public class Graph {
    public int n; //n个节点
    public List<Edge>[] edges; //邻边
    public Graph(int n) {
        this.n = n;
        edges = new LinkedList[n];
    }
}
