package educative.twopointers;

import java.util.*;

/*
Educative 6
Given an array arr of unsorted numbers and a target sum,
count all triplets in it such that arr[i] + arr[j] + arr[k] < target where i, j,
and k are three different indices.
Write a function to return the count of such triplets.

问题描述：找出数组中三数之和小于target的子数组数量

思路：双指针

详细过程：
排序数组，排好后遍历数组，在while循环里遍历时，如果和小于target，则有right - left种组合
*/
class TripletWithSmallerSum {

    public static int searchTriplets(int[] arr, int target) {
        Arrays.sort(arr);
        int count = 0;
        for (int i = 0; i < arr.length - 2; i++) {
            count = count + searchPair(arr, target - arr[i], i);
        }
        return count;
    }

    private static int searchPair(int[] arr, int targetSum, int first) {
        int count = 0;
        int left = first + 1, right = arr.length - 1;
        while (left < right) {
            // found the triplet
            if (arr[left] + arr[right] < targetSum) {
                // since arr[right] >= arr[left], therefore, we can replace arr[right] by any number between
                // left and right to get a sum less than the target sum
                count = count + (right - left);
                left++;
            } else {
                right--; // we need a pair with a smaller sum
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(TripletWithSmallerSum.searchTriplets(new int[]{-1, 0, 2, 3}, 3));
//        System.out.println(TripletWithSmallerSum.searchTriplets(new int[]{-1, 4, 2, 1, 3}, 5));
    }
}
