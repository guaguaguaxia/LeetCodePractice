package FirstWeek.Stack;

import java.util.Arrays;
import java.util.Stack;


/*
 * 2020-06-29 First Pass
 * 2020-07-01 单调栈
 * 2020-07-02 单调栈
 * */
public class LargestRectangleInHistogram84 {

    public static void main(String[] args) {
        int[] nums = {2, 1, 5, 6, 2, 3};
        int i = largestRectangleArea2(nums);
        System.out.println(i);

//        int[] nums = {2, 1, 2, 4, 3};
//        int[] ints = nextGreaterElement(nums);
//
//        System.out.println(Arrays.toString(ints));
    }


    public static int largestRectangleArea2(int[] heights) {
        int n = heights.length;
        int[] left = new int[n];
        int[] right = new int[n];

        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < n; ++i) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            left[i] = (stack.isEmpty() ? -1 : stack.peek());
            stack.push(i);
        }

        stack.clear();
        for (int i = n - 1; i >= 0; --i) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            right[i] = (stack.isEmpty() ? n : stack.peek());
            stack.push(i);
        }

        int ans = 0;
        for (int i = 0; i < n; ++i) {
            ans = Math.max(ans, (right[i] - left[i] - 1) * heights[i]);
        }
        return ans;
    }


    /**
     * 暴力解法
     *
     * @param heights
     * @return
     */
    private static int largestRectangleArea(int[] heights) {
        int len = heights.length;
        // 特判
        if (len == 0) {
            return 0;
        }
        int res = 0;
        for (int i = 0; i < len; i++) {
            // 找左边最后 1 个大于等于 heights[i] 的下标
            int left = i;
            int curHeight = heights[i];
            while (left > 0 && heights[left - 1] >= curHeight) {
                left--;
            }
            // 找右边最后 1 个大于等于 heights[i] 的索引
            int right = i;
            while (right < len - 1 && heights[right + 1] >= curHeight) {
                right++;
            }

            int width = right - left + 1;
            res = Math.max(res, width * curHeight);
        }
        return res;
    }



    public static int[] nextGreaterElement(int[] nums) {
        int[] ret = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            while (!stack.empty() && stack.peek() <= nums[i]) {
                stack.pop();
            }
            ret[i] = stack.empty() ? -1 : stack.peek();
            stack.push(nums[i]);
        }
        return ret;
    }

}
