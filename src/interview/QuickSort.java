package interview;

import java.util.Arrays;
import java.util.Random;
import java.util.Stack;

public class QuickSort {


    // 快速排序 2：双指针（指针对撞）快速排序

    /**
     * 列表大小等于或小于该大小，将优先于 quickSort 使用插入排序
     */
    private static final int INSERTION_SORT_THRESHOLD = 7;

    private static final Random RANDOM = new Random();

    public int[] sortArray(int[] nums) {
        int len = nums.length;
        quickSort(nums, 0, len - 1);
        return nums;
    }

    private void quickSort(int[] nums, int left, int right) {
        // 小区间使用插入排序
        if (right - left <= INSERTION_SORT_THRESHOLD) {
            insertionSort(nums, left, right);
            return;
        }

        int pIndex = partition(nums, left, right);
        quickSort(nums, left, pIndex - 1);
        quickSort(nums, pIndex + 1, right);
    }

    /**
     * 对数组 nums 的子区间 [left, right] 使用插入排序
     *
     * @param nums  给定数组
     * @param left  左边界，能取到
     * @param right 右边界，能取到
     */
    private void insertionSort(int[] nums, int left, int right) {
        for (int i = left + 1; i <= right; i++) {
            int temp = nums[i];
            int j = i;
            while (j > left && nums[j - 1] > temp) {
                nums[j] = nums[j - 1];
                j--;
            }
            nums[j] = temp;
        }
    }

    private int partition(int[] nums, int left, int right) {
//        int randomIndex = left + RANDOM.nextInt(right - left + 1);
//        swap(nums, randomIndex, left);

        int pivot = nums[left];
        int lt = left + 1;
        int gt = right;

        // 循环不变量：
        // all in [left + 1, lt) <= pivot
        // all in (gt, right] >= pivot
        while (true) {
            while (lt <= right && nums[lt] < pivot) {
                lt++;
            }

            while (gt > left && nums[gt] > pivot) {
                gt--;
            }

            if (lt >= gt) {
                break;
            }

            // 细节：相等的元素通过交换，等概率分到数组的两边
            swap(nums, lt, gt);
            lt++;
            gt--;
        }
        swap(nums, left, gt);
        return gt;
    }

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

    public void quick_sort(int[] a, int left, int right) {
        //结束迭代
        if (left > right) {
            return;
        }
        int i = left;
        int j = right;
        //设置基准值，将最左端元素作为基准值
        int temp = a[left];

        while (i != j) {
            //往左移位，直到小于temp
            while (i < j && a[j] >= temp) {
                j--;
            }
            //往右移位，直到大于temp
            while (i < j && a[i] <= temp) {
                i++;
            }
            if (i < j) {
                //交换彼此的数据
                int tt = a[i];
                a[i] = a[j];
                a[j] = tt;
            }

        }

        //交换基位数据
        int kk = a[i];
        a[i] = temp;
        a[left] = kk;

        //下一次迭代
        quick_sort(a, left, i - 1);//左半边
        quick_sort(a, j + 1, right);//右半边

    }


    public int[] nonRecurQuickSort(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        Stack<Integer> stack = new Stack<>();
        if (start < end) {
            stack.push(end);
            stack.push(start);
            while (!stack.isEmpty()) {
                int l = stack.pop();
                int r = stack.pop();
                int index = partition1(nums, l, r);
                if (l < index - 1) {
                    stack.push(index - 1);
                    stack.push(l);
                }
                if (r > index + 1) {
                    stack.push(r);
                    stack.push(index + 1);
                }
            }
        }
        return nums;
    }

    private int partition1(int[] a, int start, int end) {
        int point = a[start];
        while (start < end) {
            while (start < end && a[end] >= point) {
                end--;
            }

            a[start] = a[end];
            while (start < end && a[start] <= point) {
                start++;
            }
            a[end] = a[start];
        }
        a[start] = point;
        return start;
    }


    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        int[] a = {49, 38, 65, 97, 76, 13, 27, 49};
        quickSort.sortArray(a);
        System.out.println(Arrays.toString(a));
    }
}
