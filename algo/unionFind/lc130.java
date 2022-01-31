package algo.unionFind;

class UF{
    int[] parents;
    public UF(int[] parents) {
        this.parents = parents;
        for (int i = 0; i < parents.length; i++) {
            parents[i] = i;
        }
    }
    public void unite(int p, int q) {
        int pp = root(p);
        int qq = root(q);
        if (pp == qq) return;
        if (pp == -1) {
            parents[qq] = pp;
        } else {
            parents[pp] = qq;
        }
    }
    public int root(int p) {
        while (parents[p] != -1 && parents[p] != p) {
            p = parents[p];
        }
        return parents[p];
    }
    public void assign(int p, int val) {
        parents[p] = val;
    }
}
public class lc130 {

    public void solve(char[][] board) {
        int m = board.length, n = board[0].length;
        UF uf = new UF(new int[m*n]);
        for (int y = 0; y < n; y++) {
            if (board[0][y] == 'O') uf.assign(y, -1); //x*n + y
            if (board[m-1][y] == 'O') uf.assign((m-1)*n+y, -1); //x*n + y
        }
        for (int x = 0; x < m - 1; x++) {
            if (board[x][0] == 'O') uf.assign(x*n, -1);
            if (board[x][n-1] == 'O') uf.assign(x*n+n-1, -1);
        }
        for (int x = 1; x < m-1; x++) {
            for (int y = 1; y < n-1; y++) {
                if (board[x][y] == 'X') continue;
                if (board[x-1][y] == 'O') uf.unite((x-1)*n+y, x*n + y);
                if (board[x+1][y] == 'O') uf.unite((x+1)*n+y, x*n + y);
                if (board[x][y+1] == 'O') uf.unite(x*n+y+1, x*n + y);
                if (board[x][y-1] == 'O') uf.unite(x*n+y-1, x*n + y);
            }
        }
        for (int x = 1; x < m-1; x++) {
            for (int y = 1; y < n-1; y++) {
                if (uf.root(x*n+y) != -1) board[x][y] = 'X';
            }
        }
    }
}
