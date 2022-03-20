package LCP.LCP285;

import java.util.Stack;

/**
 * "SSRSSRLLRSLLRSRSSRLRRRRLLRRLSSRR"
 */
public class L2 {
    public static void main(String[] args) {
        new L2().countCollisions("SSRSSRLLRSLLRSRSSRLRRRRLLRRLSSRR");
        //new L2().countCollisions("RLRSLL");
    }
    public int countCollisions(String directions) {
        char[] chs = directions.toCharArray();
        Stack<Character> stack = new Stack<>();
        int ans = 0;
        stack.push(chs[0]);
        for (int i = 1; i < chs.length; i++) {
            char top = stack.peek();
            if (top == 'L') {
                stack.push(chs[i]);
            } else if (top == 'S') {
                if (chs[i] == 'L') {
                    ans += 1;
                    stack.push('S');
                } else {
                    stack.push(chs[i]); //R
                }
            } else if (top == 'R'){
                if (chs[i] == 'R') stack.push(chs[i]);
                else {
                    if (chs[i] == 'L') ans+=2;
                    if (chs[i] == 'S') ans+=1;
                    stack.pop();
                    while (!stack.isEmpty() && stack.peek() == 'R') {
                        ans+=1;
                        stack.pop();
                    }
                    stack.push('S');
                }
            }
        }
        return ans;
    }
}
