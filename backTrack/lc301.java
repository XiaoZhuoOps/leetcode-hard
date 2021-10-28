class Solution {

    int lRedundant = 0, rRedundant = 0;
    String s;

    Set<String> set = new HashSet<>();

    public List<String> removeInvalidParentheses(String s) {
        this.s = s;
        String cur = "";
        int score = 0;

        calcuRemove(s);
        dfs(0, cur, lRedundant, rRedundant, score);
        return new ArrayList<>(set);
    }

    void dfs(int index, String cur, int lRedundant, int rRedundant, int score) {
        char ch = s.charAt(index);
        if(ch == '(') {
            dfs(index+1, cur, lRedundant-1, rRedundant, score);
            dfs(index+1, cur+String.valueOf(ch)
        }
    }


    void calcuRemove(String s) {
        for(int i = 0; i < s.length(); i++) {
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