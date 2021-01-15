package newcodetop200.part1;

import java.util.Random;

public class FindKthLargest {

    public static void main(String[] args) {
        int[] a = {3, 2, 1, 5, 6, 4, 8, 9, 10};
        FindKthLargest f = new FindKthLargest();
        int kthLargest = f.findKthLargest(a, 9);
        System.out.println(kthLargest);
    }

    private static Random random = new Random(System.currentTimeMillis());

    public int findKthLargest(int[] nums, int k) {
        if (k > nums.length){
            return 0;
        }
        // 首先随机打乱数组
        shuffle(nums);
        int len = nums.length;
        int target = len - k;
        int left = 0;
        int right = len - 1;
        while (true) {
            int index = partition(nums, left, right);
            if (index < target) {
                left = index + 1;
            } else if (index > target) {
                right = index - 1;
            } else {
                return nums[index];
            }
        }
    }

    int partition(int[] nums, int lo, int hi) {
        if (lo == hi) {
            return lo;
        }
        // 将 nums[lo] 作为默认分界点 pivot
        int pivot = nums[lo];
        // j = hi + 1 因为 while 中会先执行 --
        int i = lo + 1, j = hi;
        while (true) {
            // 保证 nums[lo..i] 都小于 pivot
            while (nums[i] < pivot) {
                i++;
                if (i == hi) {
                    break;
                }
            }
            // 保证 nums[j..hi] 都大于 pivot
            while (nums[j] > pivot) {
                j--;
                if (j == lo) {
                    break;
                }
            }
            if (i >= j) {
                break;
            }
            // 如果走到这里，一定有：
            // nums[i] > pivot && nums[j] < pivot
            // 所以需要交换 nums[i] 和 nums[j]，
            // 保证 nums[lo..i] < pivot < nums[j..hi]
            swap(nums, i, j);
        }
        // 将 pivot 值交换到正确的位置
        swap(nums, j, lo);
        // 现在 nums[lo..j-1] < nums[j] < nums[j+1..hi]
        return j;
    }

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

    // 对数组元素进行随机打乱
    void shuffle(int[] nums) {
        int n = nums.length;
        Random rand = new Random();
        for (int i = 0; i < n; i++) {
            // 从 i 到最后随机选一个元素
            int r = i + rand.nextInt(n - i);
            swap(nums, i, r);
        }
    }


}
