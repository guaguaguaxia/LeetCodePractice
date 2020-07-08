package FirstWeek.Array;



/*
* 2020-06-23 First Pass
* 2020-06-24 Second Pass
* 2020-06-25 Third Pass
* 2020-07-08 fourth Pass
* */
public class ContainerWithMostWater11 {

    public static void main(String[] args) {
        int[] nums = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int ret = maxArea2(nums);
        System.out.println(ret);
    }


    /**
     * 双指针
     * 定义双指针，两边向里逼近，谁的高小谁向里逼近
     * @param height
     * @return
     */
    public static int maxArea2(int[] height) {
        int i = 0;
        int j = height.length - 1;
        int maxArea = 0;
        while (i < j){
            if (height[i] > height[j]){
                maxArea = Math.max(maxArea,(j - i) * height[j]);
                j-- ;
            }else {
                maxArea = Math.max(maxArea,(j - i) * height[i]);
                i ++;
            }
        }
        return maxArea;
    }


    /**
     * 暴力解法
     *
     * @param height
     * @return
     */
    private static int maxArea1(int[] height) {
        if (height.length < 2) {
            return 0;
        }
        int maxArea = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int area = height[i] < height[j] ? (j - i) * height[i] : (j - i) * height[j];
                if (area > maxArea) {
                    maxArea = area;
                }
            }
        }
        return maxArea;
    }
}
