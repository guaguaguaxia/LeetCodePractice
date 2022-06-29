package everyday.a20220628;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author guaguaguaxia
 */
public class ThreeSum {

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
}
