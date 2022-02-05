package algo.stack;
import java.util.Stack;

/**
 * 1、建模与选型 括号匹配相关题目99%都用栈
 * 2、算法逻辑
 * 3、代码实现
 * 4、debug与总结
 */
public class lc394 {
    public static void main(String[] args) {
        new lc394().decodeString("3[abc]2[bc]");
    }
    public String decodeString(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();

        for (char ch : chars) {
            if (ch == ']') {
                //String
                StringBuilder sb = new StringBuilder();
                while (stack.peek() != '[') {
                    char pop = stack.pop();
                    sb.append(pop);
                }
                stack.pop();
                //num
                int num = 0, digit = 1;
                while (!stack.isEmpty() &&
                        (stack.peek() >= '0' && stack.peek() <= '9')) {
                    num += (digit * (stack.pop()-'0'));
                    digit *= 10;
                }
                //calc
                String str = sb.toString();
                for (int i = 1; i < num; i++) {
                    sb.append(str);
                }
                for (int i = sb.length()-1; i >= 0; i--) {
                    stack.push(sb.charAt(i));
                }
            } else {
                stack.push(ch);
            }
        }
        StringBuilder sb2 = new StringBuilder();
        while (!stack.isEmpty()) {
            sb2.append(stack.pop());
        }
        return sb2.reverse().toString();
    }
}
