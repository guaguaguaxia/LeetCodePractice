package educative.twopointers;

/*
Educative 3
Given a sorted array, create a new array containing squares of all the numbers of the input array in the sorted order.

问题描述：给定一个排序数组，创建一个排序数组平方数的新的排序数组

思路：双指针

详细过程：
用两个指针分别指向数组开头和末尾，在while循环中计算出两个指针指向元素的平方值
哪个大把他们放进元素的末尾

*/

class SortedArraySquares {

    public static int[] makeSquares(int[] arr) {
        int n = arr.length;
        int[] squares = new int[n];
        int highestSquareIdx = n - 1;
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int leftSquare = arr[left] * arr[left];
            int rightSquare = arr[right] * arr[right];
            if (leftSquare > rightSquare) {
                squares[highestSquareIdx--] = leftSquare;
                left++;
            } else {
                squares[highestSquareIdx--] = rightSquare;
                right--;
            }
        }
        return squares;
    }

    public static void main(String[] args) {

        int[] result = SortedArraySquares.makeSquares(new int[]{-2, -1, 0, 2, 3});
        for (int num : result) {
            System.out.print(num + " ");
        }
        System.out.println();

        result = SortedArraySquares.makeSquares(new int[]{-3, -1, 0, 1, 2});
        for (int num : result) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
