package educative.twopointers;

/*
Educative 4
Given an array of unsorted numbers, find all unique triplets in it that add up to zero.

问题描述：寻找数组中某三个数之和为零的数组

思路：双指针

详细思路：

三数之和中找两数之和


*/

import java.util.*;

class TripletSumToZero {

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList();
        int len = nums.length;
        if (nums == null || len < 3) {
            return ans;
        }
        Arrays.sort(nums);
        for (int i = 0; i < len; i++) {
            if (nums[i] > 0) {
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            searchTwoSum(nums, i, ans);
        }
        return ans;
    }

    private static void searchTwoSum(int[] nums, int i, List<List<Integer>> ans) {
        int left = i + 1;
        int right = nums.length - 1;
        while (left < right) {
            int sum = nums[i] + nums[left] + nums[right];
            if (sum == 0) {
                ans.add(Arrays.asList(nums[i], nums[left], nums[right]));
                while (left < right && nums[left] == nums[left + 1]) {
                    left++; // 去重
                }
                while (left < right && nums[right] == nums[right - 1]) {
                    right--; // 去重
                }
                left++;
                right--;
            } else if (sum < 0) {
                left++;
            } else {
                right--;
            }
        }
    }

    public static List<List<Integer>> searchTriplets(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> triplets = new ArrayList<>();
        for (int i = 0; i < arr.length - 2; i++) {
            // skip same element to avoid duplicate triplets
            if (i > 0 && arr[i] == arr[i - 1]) {
                continue;
            }
            searchPair(arr, -arr[i], i + 1, triplets);
        }

        return triplets;
    }

    private static void searchPair(int[] arr, int targetSum, int left, List<List<Integer>> triplets) {
        int right = arr.length - 1;
        while (left < right) {
            int currentSum = arr[left] + arr[right];
            // found the triplet
            if (currentSum == targetSum) {
                triplets.add(Arrays.asList(-targetSum, arr[left], arr[right]));
                left++;
                right--;
                while (left < right && arr[left] == arr[left - 1]) {
                    left++; // skip same element to avoid duplicate triplets
                }
                while (left < right && arr[right] == arr[right + 1]) {
                    right--; // skip same element to avoid duplicate triplets
                }
            } else if (targetSum > currentSum) {
                left++; // we need a pair with a bigger sum
            } else {
                right--; // we need a pair with a smaller sum
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(TripletSumToZero.threeSum(new int[]{-3, 0, 1, 2, -1, 1, -2}));
        System.out.println(TripletSumToZero.searchTriplets(new int[]{-5, 2, -1, -2, 3}));
    }
}
