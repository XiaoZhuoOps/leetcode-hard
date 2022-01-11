package basic.graph.sp;

import basic.DS.Graph.Node;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;


//基于最小路径树的实现
public class Dijstra {
    //邻接表表示的图
    List<Integer>[] graph;
    int[] shortestPath(List<Integer>[] graph, int start) {
        this.graph = graph;
        int[] sp = new int[graph.length];
        PriorityQueue<Node> pq = new PriorityQueue<>(){
            @Override
            public Comparator<? super Node> comparator() {
                return (o1, o2) -> o1.path - o2.path;
            }
        };
        pq.add(new Node(0, start));
        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (sp[cur.index] != 0) continue; //该节点已经存在最短路径
            sp[cur.index] = cur.path; //出队即代表确定了该节点的最短路径
            for (Node adj : adj(cur)) {
                if (sp[adj.index] != 0) continue; //该节点已经存在于最短路径树中
                pq.add(adj); //把邻接节点入队
            }
        }
        return sp;
    }
    Node[] adj(Node index) {
        //计算节点路径
    }
}

//基于BFS + DP的实现
class Dijstra2{
    List<Integer>[] graph;
    int[] shortestPath(List<Integer>[] graph, int start) {
        this.graph = graph;
        int[] sp = new int[graph.length];
        PriorityQueue<Node> pq = new PriorityQueue<>(){
            @Override
            public Comparator<? super Node> comparator() {
                return (o1, o2) -> o1.path - o2.path;
            }
        };
        pq.add(new Node(0, start));
        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (sp[cur.index] < cur.path) continue;
            for (Node adj : adj(cur)) {
                if (sp[adj.index] > cur.path) {
                    sp[cur.index] = cur.path;
                    pq.add(adj); //把邻接节点入队
                }
            }
        }
        return sp;
    }
    Node[] adj(Node index) {
    }
}