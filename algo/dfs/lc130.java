package algo.dfs;

public class lc130 {
    boolean[][] arr;
    char[][] board;
    int m, n;
    public void solve(char[][] board) {
        this.m = board.length;
        this.n = board[0].length;
        this.arr = new boolean[m][n];
        this.board = board;
        for (int y = 0; y < n; y++) {
            dfs(0,y);
            dfs(m-1,y);
        }
        for (int x = 1; x < m-1; x++) {
            dfs(x,0);
            dfs(x,n-1);
        }
        for (int x = 1; x < m-1; x++) {
            for (int y = 1; y < n-1; y++) {
                if (board[x][y] == 'O' && !arr[x][y]) board[x][y] = 'X';
            }
        }
    }

    void dfs(int x, int y) {
        if (x < 0 || x >= m || y < 0 || y >= n) return;
        if (board[x][y] != 'O') return;
        if (arr[x][y]) return;
        arr[x][y] = true;
        dfs(x+1,y);
        dfs(x,y+1);
        dfs(x-1,y);
        dfs(x,y-1);
    }
}
