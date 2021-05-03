package newcodetop200.part3;

import java.util.Arrays;

public class Rotate {

    public static void main(String[] args) {
        int[][] arr =
                {
                        {1, 2, 3},
                        {4, 5, 6},
                        {7, 8, 9}
                };

        rotate(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }
    }

    public static void rotate(int[][] matrix) {
        int length = matrix.length;
        //先上下交换
        for (int i = 0; i < length / 2; i++) {
            int temp[] = matrix[i];
            matrix[i] = matrix[length - i - 1];
            matrix[length - i - 1] = temp;
        }
        //再按照对角线交换
        for (int i = 0; i < length; ++i) {
            for (int j = i + 1; j < length; ++j) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

}
