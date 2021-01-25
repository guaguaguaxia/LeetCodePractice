package newcodetop200.part2;

public class Trap {

    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int trap = trap(arr);
        System.out.println(trap);
    }

    static int trap(int[] height) {
        if (height.length == 0) {
            return 0;
        }
        int n = height.length;
        int left = 0;
        int right = n - 1;
        int res = 0;

        int l_max = height[0];
        int r_max = height[n - 1];

        while (left <= right) {
            l_max = Math.max(l_max, height[left]);
            r_max = Math.max(r_max, height[right]);

            // res += min(l_max, r_max) - height[i]
            if (l_max < r_max) {
                res = res + l_max - height[left];
                left++;
            } else {
                res = res + r_max - height[right];
                right--;
            }
        }
        return res;
    }

}
