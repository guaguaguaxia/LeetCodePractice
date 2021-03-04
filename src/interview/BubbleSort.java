package interview;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {
        int[] num = {4,5,6,3,2,1};
        bubbleSort(num,num.length);
    }

    // 冒泡排序，a表示数组，n表示数组大小
    public static void bubbleSort(int[] a, int n) {
        if (n <= 1){
            return;
        }

        for (int i = 0; i < n; i++) {
            // 提前退出冒泡循环的标志位
            boolean flag = false;
            for (int j = 0; j < n - i - 1; j++) {
                // 交换
                if (a[j] > a[j+1]) {
                    int tmp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = tmp;
                    // 表示有数据交换
                    flag = true;
                }
            }
            System.out.println(Arrays.toString(a));
            if (!flag) {
                break;  // 没有数据交换，提前退出
            }
        }
    }

}
