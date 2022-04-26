package educative.slidingwindow;

/**
 * @author guaguaguaxia
 */
//  https://leetcode.com/problems/maximum-subarray/   类似

/*
educative  1
Given an array of positive numbers and a positive number ‘k,’ find the maximum sum of any contiguous subarray of size ‘k’.

问题描述：给出一个正整数数组和一个正整数的size K，找出在子数组size为K时的最大值

解决思路：滑动窗口，用一个窗口框住size为K的子数组，在窗口不断右滑的过程中计算出最大值

具体过程：
定义变量windowSum记录滑动窗口内的数组元素总和
定义变量maxSum作为结果值，每次滑动窗口后跟windowSum对比谁比较大
定义变量windowStart作为滑动窗口的左值，windowEnd作为右值

windowEnd递增，计算出当前窗口的windowSum。
当窗口size大于K时，
在maxSum和windowSum对比出最大值赋给maxSum，窗口左值windowStart加1，windowSum减去滑出去的左值
*/


class MaxSumSubArrayOfSizeK {
    public static int findMaxSumSubArray(int k, int[] arr) {
        int windowSum = 0, maxSum = 0;
        int windowStart = 0;
        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            windowSum = windowSum + arr[windowEnd];

            if (windowEnd >= k - 1) {
                maxSum = Math.max(maxSum, windowSum);
                windowSum = windowSum - arr[windowStart];
                windowStart++;
            }
        }

        return maxSum;
    }

    public static void main(String[] args) {
        System.out.println("Maximum sum of a subarray of size K: "
                + MaxSumSubArrayOfSizeK.findMaxSumSubArray(3, new int[]{2, 1, 5, 1, 3, 2}));
        System.out.println("Maximum sum of a subarray of size K: "
                + MaxSumSubArrayOfSizeK.findMaxSumSubArray(2, new int[]{2, 3, 4, 1, 5}));
        
    }
}
