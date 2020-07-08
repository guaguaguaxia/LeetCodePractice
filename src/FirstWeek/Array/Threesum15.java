package FirstWeek.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
* 2020-06-27 First Pass
* 2020-07-08 check
* */


public class Threesum15 {
    public static void main(String[] args) {
        int[] nums = {-4, -1, -1, -1, 0, 1, 2};
        List<List<Integer>> lists = threeSum(nums);
        System.out.println(Arrays.toString(lists.toArray()));
//        for (List<Integer> list : lists) {
//            System.out.println(Arrays.toString(list.toArray()));
//        }
    }

    private static List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);

        List<List<Integer>> res = new ArrayList<>();
        for (int k = 0; k < nums.length - 2; k++) {
            /*前置判断*/
            if (nums[k] > 0) {
                break;
            }
            if (k > 0 && nums[k] == nums[k - 1]) {
                continue;
            }


            int i = k + 1;

            int j = nums.length - 1;

            while (i < j) {
                int sum = nums[k] + nums[i] + nums[j];
                if (sum < 0) {
                    while (i < j && nums[i] == nums[++i]) ;
                } else if (sum > 0) {
                    while (i < j && nums[j] == nums[--j]) ;
                } else {
                    res.add(new ArrayList<Integer>(Arrays.asList(nums[k], nums[i], nums[j])));
                    while (i < j && nums[i] == nums[++i]) ;
                    while (i < j && nums[j] == nums[--j]) ;
                }
            }
        }
        return res;
    }
}

//while(i < j) {
//        i = i + 1;
//        if(nums[i - 1] == nums[i]) {
//        // do sth.
//        }
//        }
