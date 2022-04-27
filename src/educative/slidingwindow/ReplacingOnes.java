package educative.slidingwindow;



// https://leetcode-cn.com/problems/max-consecutive-ones-iii/  1004
/*
Given an array containing 0s and 1s, if you are allowed to replace no more than ‘k’ 0s with 1s,
find the length of the longest contiguous subarray having all 1s.

问题描述：给定一个数组，包含0或者1，如果允许替换不超过K个的0，找出最长的全是1的子数组

解决思路：滑动窗口

具体过程：
定义滑动窗口左值windowStart，右值windowEnd，窗口内最大的1的数量maxOnesCount，定义maxLength为结果值

windowEnd递增，窗口变大，如果数字是1，maxOnesCount++
当窗口大小大于maxOnesCount + k时，说明已经不满足条件
窗口左值右移，如果右移过程中遇到1，则maxOnesCount--。（就是说如果少了一个1，则长度也少了1）
最后maxLength和窗口大小比较，维护maxLength
*/


class ReplacingOnes {
    public static int findLength(int[] arr, int k) {
        int windowStart = 0, maxLength = 0, maxOnesCount = 0;
        // try to extend the range [windowStart, windowEnd]
        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            if (arr[windowEnd] == 1){
                maxOnesCount++;
            }

            // current window size is from windowStart to windowEnd, overall we have a maximum of 1s
            // repeating a maximum of 'maxOnesCount' times, this means that we can have a window with
            // 'maxOnesCount' 1s and the remaining are 0s which should replace with 1s.
            // now, if the remaining 0s are more than 'k', it is the time to shrink the window as we
            // are not allowed to replace more than 'k' Os
            if (windowEnd - windowStart + 1 > k + maxOnesCount) {
                if (arr[windowStart] == 1){
                    maxOnesCount--;
                }
                windowStart++;
            }

            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(ReplacingOnes.findLength(new int[]{0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1}, 2));
        System.out.println(ReplacingOnes.findLength(new int[]{0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1}, 3));
    }
}
