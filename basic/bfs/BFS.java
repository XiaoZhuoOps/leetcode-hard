package basic.bfs;

public class BFS {
    public BFS() {
        while(!q.isEmpty()){
            Node front = q.poll();
            visit(front)
            for(Node adj:adjs){
                if(visited[adj]!=null) continue
                q.add(adj)
                visited[adj] = 1
            }
        }
    }
}
