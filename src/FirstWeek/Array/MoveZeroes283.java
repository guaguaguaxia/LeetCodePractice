package FirstWeek.Array;


/*
 * 2020-06-22 First Pass
 * 2020-06-23 Second Pass
 * 2020-06-24 Third Pass
 * */


import java.util.Arrays;

public class MoveZeroes283 {
    public static void main(String[] args) {
        int[] nums = {1, 1, 0, 0, 0, 3, 12};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 定义快慢指针i、j,由i指针去寻找需要调换的不等于0的元素，和j指针元素调换
     */
    private static void moveZeroes(int[] nums) {
        if (nums == null) {
            return;
        }
        int j = 0;
        for(int i = 0;i < nums.length;i++){
            if (nums[i] != 0){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j++;
            }
        }
    }

}
