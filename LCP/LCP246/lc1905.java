package LCP.LCP246;

public class lc1905 {
    boolean flag = true;
    int[][] grid1;
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int res = 0;
        this.grid1 = grid1;
        int m = grid2.length, n = grid2[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid2[i][j] == 0) continue;
                flag = true;
                dfs(grid2,i,j);
                if (flag) res++;
            }
        }
        return res;
    }
    void dfs(int[][] grid2, int i, int j) {
        if (i < 0 || grid2.length <= i || j < 0 || grid2[0].length <= j || grid2[i][j] == 0) return;

        if (grid1[i][j] != 1) flag = false;
        grid2[i][j] = 0;

        dfs(grid2, i-1, j);
        dfs(grid2, i+1, j);
        dfs(grid2, i, j-1);
        dfs(grid2, i, j+1);
    }
}
