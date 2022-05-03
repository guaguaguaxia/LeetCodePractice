package educative.twopointers;

import java.util.HashMap;

/*
Educative 1
Given an array of sorted numbers and a target sum,
find a pair in the array whose sum is equal to the given target.

问题描述：给一个排好序的数组和target值，找出数组中的两个元素之和等于target值的下标

思路：HashMap

详细过程：
遍历数组，用一个HashMap装数据，key是数组值，value是数组元素，如果Map中的元素有target-当前数组元素，则说明找到目标结果

*/

class PairWithTargetSum {

    public static int[] search(int[] arr, int targetSum) {
        HashMap<Integer, Integer> nums = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (nums.containsKey(targetSum - arr[i])){
                return new int[] { nums.get(targetSum - arr[i]), i };
            }
            else{
                nums.put(arr[i], i);
            }
        }
        return new int[] { -1, -1 };
    }

    public static void main(String[] args) {
        int[] result = PairWithTargetSum.search(new int[] { 1, 2, 3, 4, 6 }, 6);
        System.out.println("Pair with target sum: [" + result[0] + ", " + result[1] + "]");
        result = PairWithTargetSum.search(new int[] { 2, 5, 9, 11 }, 11);
        System.out.println("Pair with target sum: [" + result[0] + ", " + result[1] + "]");
    }
}
