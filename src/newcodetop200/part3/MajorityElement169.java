package newcodetop200.part3;

public class MajorityElement169 {
    public static void main(String[] args) {
        int[] nums = {2,2,1,1,1,2,2};
        int i = majorityElement(nums);
        System.out.println(i);
    }

    public static int majorityElement(int[] nums) {
        int cand_num = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; ++i) {
            if (cand_num == nums[i]) {
                ++count;
            } else if (--count == 0) {
                cand_num = nums[i];
                count = 1;
            }
        }
        return cand_num;
    }

}
