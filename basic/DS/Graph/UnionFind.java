package basic.DS.Graph;

/**
 * 并查集实现
 */
public class UnionFind {

    int[] parents;

    public UnionFind(int[] parents) {
        this.parents = parents;
    }

    void union(int p, int q) {
        if (connected(p,q)) return;
        parents[root(p)] = root(q);
    }

    boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    int root(int p) {
        int par = p;
        while (parents[par] != par) {
            par = parents[par];
        }
        return par;
    }
}
