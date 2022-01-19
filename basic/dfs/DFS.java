package basic.dfs;

public class DFS {
    public DFS() {
        void Dfs(Graph G)
        for(int V:G)
            dfs(G,V)

        void dfs(Graph G, int V)
        mraked[V] = true;
        for(int W: V.adjs())
            if(!marked[V])
                dfs(G,W)
    }
}
