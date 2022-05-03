package educative.twopointers;


/*
Educative 2
Given an array of sorted numbers, remove all duplicates from it. You should not use any extra space;
after removing the duplicates in-place return the length of the subarray that has no duplicate in it.

问题描述：给定一个排序好的数组，移除所有重复元素，返回移除后的长度。

思路：双指针

详细过程：
定义一个指针指向不重复的元素，叫原地指针，
遍历数组，如果找到了跟原地指针指向的元素不相同的元素，则交换元素，原地指针++

*/

class RemoveDuplicates {

    public static int remove(int[] arr) {
        // index of the next non-duplicate element
        int nextNonDuplicate = 1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[nextNonDuplicate - 1] != arr[i]) {
                arr[nextNonDuplicate] = arr[i];
                nextNonDuplicate++;
            }
        }

        return nextNonDuplicate;
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 2, 2, 2, 3, 3, 3, 3, 6, 6, 6, 9, 9, 9, 10, 10, 10 };
        System.out.println(RemoveDuplicates.remove(arr));

//        arr = new int[] { 2, 2, 2, 11 };
//        System.out.println(RemoveDuplicates.remove(arr));
    }
}
