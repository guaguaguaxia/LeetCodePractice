package FirstWeek.Array;


/*
 * 2020-06-22
 *
 * */

/*
* 定义快慢指针i、j,由i指针去寻找需要调换的不等于0的元素，和j指针元素调换
* */
public class MoveZeroes283 {
    public static void main(String[] args) {
        int[] nums = {1, 1, 0, 0, 0, 3, 12};
        moveZeroes(nums);
    }

    private static void moveZeroes(int[] nums) {
        if (nums == null) {
            return;
        }
        //两个指针i和j
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            //当前元素!=0，就把其交换到左边，等于0的交换到右边
            if (nums[i] != 0) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
                j++;
            }
        }
    }

}
