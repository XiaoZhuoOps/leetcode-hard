package algo.DS.Graph;

/**
 * 并查集实现
 */
public class UnionFind {
    public int count; //连通分量个数
    int[] parents;
    int[] size; //每个节点作为根节点的树的大小
    public UnionFind(int n) {
        this.count = n;
        this.parents = new int[n];
        this.size = new int[n];

        for (int i = 0; i < n; i++) {
            parents[i] = i;
            size[i] = 1;
        }
    }
    public void union(int p, int q) {
        if (connected(p,q)) return;
        int pp = root(p);
        int qq = root(q);
        if (size[pp] < size[qq]) {
            parents[pp] = qq;
            size[qq] += size[pp];
        } else {
            parents[qq] = pp;
            size[pp] += size[qq];
        }
        count--;
    }
    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }
    //普通版本
    int root(int p) {
        int par = p;
        while (parents[par] != par) {
            par = parents[par];
        }
        return par;
    }
    //路径压缩版本
    //1、返回根节点
    //2、压缩路径
    int rootCompress(int p) {
        if (parents[p] != p) return p;
        parents[p] = rootCompress(parents[p]);
        return parents[p];
    }
}
