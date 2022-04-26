package educative.slidingwindow;


// https://leetcode-cn.com/problems/minimum-size-subarray-sum/   209


/*
educative  2
Given an array of positive numbers and a positive number ‘S,’
find the length of the smallest contiguous subarray whose sum is greater than or equal to ‘S’. Return 0 if no such subarray exists.


问题描述：给出一个正整数数组和一个正整数的S，找出子数组和大于S时的最小size值

解决思路：滑动窗口，用一个窗口框住一个子数组，在窗口右端不断右移的过程中得出答案

具体过程：
定义变量windowSum记录滑动窗口内的数组元素总和
定义变量minLength作为结果值
定义变量windowStart作为滑动窗口的左值，windowEnd作为右值

windowEnd递增，计算窗口内的元素总和赋值给windowSum，
当windowSum大于S时，
用minLength和当前窗口size比较得出最小值，
windowSum减去index为windowStart的元素值
windowStart++，窗口左端右移动

 */


class MinSizeSubArraySum {
    public static int findMinSubArray(int S, int[] arr) {
        int windowSum = 0, minLength = Integer.MAX_VALUE;
        int windowStart = 0;
        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            windowSum = windowSum + arr[windowEnd];
            while (windowSum >= S) {
                minLength = Math.min(minLength, windowEnd - windowStart + 1);
                windowSum = windowSum - arr[windowStart];
                windowStart++;
            }
        }

        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }

    public static void main(String[] args) {
        int result = MinSizeSubArraySum.findMinSubArray(7, new int[]{2, 1, 5, 2, 3, 2});
        System.out.println("Smallest subarray length: " + result);
        result = MinSizeSubArraySum.findMinSubArray(7, new int[]{2, 1, 5, 2, 8});
        System.out.println("Smallest subarray length: " + result);
        result = MinSizeSubArraySum.findMinSubArray(8, new int[]{3, 4, 1, 1, 6});
        System.out.println("Smallest subarray length: " + result);
    }
}
