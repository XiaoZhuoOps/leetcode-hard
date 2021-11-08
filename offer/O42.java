package offer;

import java.util.Stack;

public class O42 {
    public int trap(int[] height) {
        int res = 0;

        Stack<Integer> minStack = new Stack<>();
        for (int i = 0; i < height.length; i++) {
            while (!minStack.isEmpty() && height[i] > height[minStack.peek()]) {
                int bottom = height[minStack.pop()];
                if (minStack.isEmpty()) break;
                int h = Math.min(height[i], height[minStack.peek()]) - bottom;
                int w = i - minStack.peek() - 1;
                res += w * h;
            }
            minStack.push(i);
        }
        return res;
    }

    public int trap2(int[] height) {
        int len = height.length;
        int[] leftMax = new int[len];
        int[] rightMax = new int[len];
        for (int i = 1 ; i < len; i++) {
            leftMax[i] = Math.max(leftMax[i-1], height[i-1]);
        }
        for (int j = len - 1; 0 <= j; j--) {
            rightMax[j] = Math.max(rightMax[j+1], height[j]);
        }
        int res = 0;
        for (int i = 0; i < len; i++) {
            res += (Math.min(leftMax[i], rightMax[i]) - height[i]);
        }
        return res;
    }
}
