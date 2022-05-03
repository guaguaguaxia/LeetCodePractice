package educative.twopointers;


/*
Educative 5
Given an array of unsorted numbers and a target number,
find a triplet in the array whose sum is as close to the target number as possible, return the sum of the triplet.
If there are more than one such triplet, return the sum of the triplet with the smallest sum.

问题描述：找出三数之和最接近目标值的和

思路：双指针

详细过程：
循环遍历数组，固定一个元素，在循环里定义一个元素start = i + 1，end = 数组长度 - 1
在while循环里计算sum，如果target-sum<target-ans,则ans = sum

*/

import java.util.*;

class TripletSumCloseToTarget {


    public static int searchTriplet2(int[] nums, int target) {
        Arrays.sort(nums);
        int ans = 1000000;
        for (int i = 0; i < nums.length - 2; i++) {
            int start = i + 1, end = nums.length - 1;
            while (start < end) {
                int sum = nums[start] + nums[end] + nums[i];
                if (Math.abs(target - sum) < Math.abs(target - ans)) {
                    ans = sum;
                }
                if (sum > target) {
                    end--;
                } else if (sum < target) {
                    start++;
                } else {
                    return ans;
                }
            }
        }
        return ans;
    }


    public static int searchTriplet(int[] arr, int targetSum) {
        if (arr == null || arr.length < 3) {
            throw new IllegalArgumentException();
        }

        Arrays.sort(arr);
        int smallestDifference = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length - 2; i++) {
            int left = i + 1, right = arr.length - 1;
            while (left < right) {
                // comparing the sum of three numbers to the 'targetSum' can cause overflow
                // so, we will try to find a target difference
                int targetDiff = targetSum - arr[i] - arr[left] - arr[right];
                //  we've found a triplet with an exact sum
                if (targetDiff == 0) {
                    // return sum of all the numbers
                    return targetSum;
                }

                // the second part of the above 'if' is to handle the smallest sum when we have more than one solution
                if (Math.abs(targetDiff) < Math.abs(smallestDifference)
                        || (Math.abs(targetDiff) == Math.abs(smallestDifference) && targetDiff > smallestDifference)) {
                    // save the closest and the biggest difference
                    smallestDifference = targetDiff;
                }

                if (targetDiff > 0) {
                    left++; // we need a triplet with a bigger sum
                } else {
                    right--; // we need a triplet with a smaller sum
                }
            }
        }
        return targetSum - smallestDifference;
    }


    public static void main(String[] args) {
        System.out.println(TripletSumCloseToTarget.searchTriplet(new int[]{-2, 0, 1, 2}, 2));
//        System.out.println(TripletSumCloseToTarget.searchTriplet(new int[]{-3, -1, 1, 2}, 1));
//        System.out.println(TripletSumCloseToTarget.searchTriplet(new int[]{1, 0, 1, 1}, 100));
    }
}
