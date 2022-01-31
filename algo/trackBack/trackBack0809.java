package algo.trackBack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class trackBack0809 {
    /**
     * res = 0;
     * def backTrack(路径，选择列表)
     *  if 满足结束条件
     *      res.add(路径)
     *      return
 *      for 选择 in 选择列表
     *      做选择
     *      backTrack(路径，选择列表)
     *      撤销选择
     */

    List<String> res = new ArrayList<>();
    StringBuilder sb = new StringBuilder();
    Stack<Character> stack = new Stack<>();

    char[] str = {'(',')'};
    int count = 0;

    public List<String> generateParenthesis(int n) {
        gen(n<<1);
        return res;
    }

    public void gen(int n){
        if (count == n) {
            if(stack.empty()){
                res.add(sb.toString());
                System.out.println(sb.toString());
            }
            return;
        }

        for (char ch : str) {
            boolean flag;
            if (ch == '(') {
                flag = true;
                stack.push(ch);
            }
            else if (!stack.empty() && stack.peek() == '(') {
                flag = false;
                stack.pop();
            }
            else continue;

            sb.append(ch);
            count++;

            gen(n);

            sb.deleteCharAt(sb.length() - 1);
            if(flag) stack.pop();
            else stack.push('(');
            count--;
        }
    }

    public static void main(String[] args) {
        List<String> strList = new trackBack0809().generateParenthesis(3);

    }
}
