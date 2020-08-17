package labuladong.chaptertwo;

import java.util.Arrays;
import java.util.Stack;

/*
* 2020-07-04  First Pass
* 2020-07-04  lazy
* */

public class DailyTemperatures739 {
    public static void main(String[] args) {
        int[] para = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] ints = dailyTemperatures(para);
        System.out.println(Arrays.toString(ints));
    }

    public static int[] dailyTemperatures(int[] temperatures) {
        int m = temperatures.length;
        int[] ans = new int[m];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < m; i++) {
            while (!stack.empty() && temperatures[stack.peek()] < temperatures[i]) {
                ans[stack.peek()] = i - stack.pop();
            }
            stack.push(i);
        }
        return ans;
    }
}
