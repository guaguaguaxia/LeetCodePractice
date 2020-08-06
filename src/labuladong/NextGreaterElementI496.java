package labuladong;

import java.util.HashMap;
import java.util.Stack;

public class NextGreaterElementI496 {

    public static void main(String[] args) {
        int[] nums1 = {4,1,2};
        int[] nums2 = {1,3,4,2};
        nextGreaterElement(nums1,nums2);
    }

    public static int[] nextGreaterElement(int[] findNums, int[] nums) {

        Stack<Integer> stack = new Stack<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] res = new int[findNums.length];
        for (int i = 0; i < nums.length; i++) {
            while (!stack.empty() && nums[i] > stack.peek()) {
                map.put(stack.pop(), nums[i]);
            }
            stack.push(nums[i]);
        }
        while (!stack.empty()) {
            map.put(stack.pop(), -1);
        }

        for (int i = 0; i < findNums.length; i++) {
            res[i] = map.get(findNums[i]);
        }
        return res;
    }

}
