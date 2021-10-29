package backTrack;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {

    int lRedundant = 0, rRedundant = 0;
    String s;

    Set<String> set = new HashSet<>();

    public List<String> removeInvalidParentheses(String s) {
        this.s = s;

        calcuRemove(s);
        dfs(0, "", lRedundant, rRedundant, 0);
        return new ArrayList<>(set);
    }

    void dfs(int index, String cur, int lRedundant, int rRedundant, int score) {
        if (lRedundant < 0 || rRedundant < 0 || score < 0) {
            return;
        }

        if (index < s.length()) {
            if (lRedundant == 0 && rRedundant == 0) {
                cur += s.substring(index);
                if (valid(cur)) {
                    set.add(cur);
                }
                return;
            }
            char ch = s.charAt(index);

            if (ch == '(') {
                if (0 < lRedundant) {
                    //不选
                    dfs(index + 1, cur, lRedundant - 1, rRedundant, score);
                    //选
                    dfs(index + 1, cur + String.valueOf(ch), lRedundant, rRedundant, score + 1);
                } else {
                    dfs(index + 1, cur + String.valueOf(ch), lRedundant, rRedundant, score + 1);
                }
            } else if (ch == ')') {
                if (0 < rRedundant) {
                    dfs(index + 1, cur, lRedundant, rRedundant - 1, score);
                    dfs(index + 1, cur + String.valueOf(ch), lRedundant, rRedundant, score - 1);
                } else {
                    dfs(index + 1, cur + String.valueOf(ch), lRedundant, rRedundant, score - 1);
                }
            } else {
                //字母
                dfs(index + 1, cur + String.valueOf(ch), lRedundant, rRedundant, score);
            }
        } else {
            if (valid(cur)) {
                set.add(cur);
            }
        }
    }

    boolean valid(String cur) {
        int count = 0;
        for (int i = 0; i < cur.length(); i++) {
            if (cur.charAt(i) == '(') {
                count++;
            } else if (cur.charAt(i) == ')') {
                count--;
                if (count < 0) {
                    return false;
                }
            }
        }
        return count == 0;
    }


    void calcuRemove(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                lRedundant++;
            } else if (s.charAt(i) == ')') {
                if (lRedundant > 0) {
                    // 栈顶必是左括号
                    lRedundant--;
                } else {
                    rRedundant++;
                }
            }
        }
    }
}