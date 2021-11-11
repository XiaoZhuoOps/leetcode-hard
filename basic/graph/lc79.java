package basic.graph;

public class lc79 {
    char[][] board;
    char[] wordCh;
    boolean[][] visited;

    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.wordCh = word.toCharArray();
        visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (wordCh[0] == board[i][j]) {
                    if (dfs(i,j,0)) return true;
                }
            }
        }
        return false;
    }

    boolean dfs(int i, int j, int k) {
        boolean flag = false;
        if (k == wordCh.length) return true;
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length
            || visited[i][j]) return false;
        if (board[i][j] == wordCh[k]) {
            visited[i][j] = true;
            flag = dfs(i+1,j,k+1) || dfs(i-1,j,k+1) ||
                    dfs(i, j+1, k+1) || dfs(i, j-1, k+1);
        }
        visited[i][j] = false;
        return flag;
    }
}
