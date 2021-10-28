package offer;

import java.util.ArrayList;
import java.util.List;

/**
 * 回溯算法
 */
public class O12 {

    public boolean exist(char[][] board, String word) {
        boolean[][] marked = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, word, marked, i, j, 1)) return true;
            }
        }
        return false;
    }

    boolean dfs(char[][] board, String word, boolean[][] marked, int i, int j, int len) {
        if (i < 0 || board.length <= i || j < 0 || board[0].length <= j ||
                board[i][j] != word.charAt(len - 1) || marked[i][j]) return false;
        if (len == word.length()) return true;
        marked[i][j] = true;
        boolean res = dfs(board, word, marked, i - 1, j, len + 1) ||
                dfs(board, word, marked, i + 1, j, len + 1) ||
                dfs(board, word, marked, i, j - 1, len + 1) ||
                dfs(board, word, marked, i, j + 1, len + 1);
        marked[i][j] = false;
        return res;
    }
}

/*
    boolean flag  = false;
    boolean[][] marked;
    public boolean exist(char[][] board, String word) {
        if(word == null || word.length() == 0) return false;
        marked = new boolean[board.length][board[0].length];
        List<List<Integer>> path = new ArrayList<>(word.length());
        for(int i = 0; i < board.length; i++){
            for (int j = 0; j < board[0].length; j++) {
                if(board[i][j] == word.charAt(0)) {
                    marked[i][j] = true;
                    add(i,j,path);
                    trackBack(board, word, path);
                    path.remove(path.size()-1);
                    marked[i][j] = false;
                }
            }
        }
        return flag;
    }

    void trackBack(char[][] board, String word, List<List<Integer>> path){
        if(path.size() == word.length() || flag) {
            flag = true;
            return;
        }
        for(choice:choices){
            if(!choice) continue;
            path.add(choice);
            mark[choice] = true;
            trackBack(board,word,path);
            path.remove(choice);
            mark[choice] = false;
        }
    }
    void add(int i, int j, List<List<Integer>> path){
        ArrayList<Integer> list = new ArrayList<>();
        list.add(i);
        list.add(j);
        path.add(list);
    }*/
