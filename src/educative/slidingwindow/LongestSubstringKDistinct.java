package educative.slidingwindow;

import java.util.*;

/*
educative  3
Given a string, find the length of the longest substring in it with no more than K distinct characters.

问题描述：给一个字符串和数字K，找出字符串中不重复的字母数不超过K的最大值

解决方案：滑动指针

具体过程：

定义记录字符频率的hashMap charFrequencyMap，
定义窗口的左值windowStart，右值windowEnd
定义结果变量maxLength

用windowEnd的递增来控制窗口的大小，当窗口移动时，维护charFrequencyMap中字符的频率
当charFrequencyMap的size大于K时，窗口左值右移，注意维护charFrequencyMap的频率，且当如果频率为0时要移除元素
maxLength和当前窗口size进行对比，维护maxLength
*/

class LongestSubstringKDistinct {
    public static int findLength(String str, int k) {
        if (str == null || str.length() == 0){
            throw new IllegalArgumentException();
        }

        int windowStart = 0, maxLength = 0;
        Map<Character, Integer> charFrequencyMap = new HashMap<>();
        // in the following loop we'll try to extend the range [windowStart, windowEnd]
        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            char rightChar = str.charAt(windowEnd);
            charFrequencyMap.put(rightChar, charFrequencyMap.getOrDefault(rightChar, 0) + 1);
            // shrink the sliding window, until we are left with 'k' distinct characters in the frequency map
            while (charFrequencyMap.size() > k) {
                char leftChar = str.charAt(windowStart);
                charFrequencyMap.put(leftChar, charFrequencyMap.get(leftChar) - 1);
                if (charFrequencyMap.get(leftChar) == 0) {
                    charFrequencyMap.remove(leftChar);
                }
                windowStart++; // shrink the window
            }
            maxLength = Math.max(maxLength, windowEnd - windowStart + 1); // remember the maximum length so far
        }

        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println("Length of the longest substring: " + LongestSubstringKDistinct.findLength("araaci", 2));
        System.out.println("Length of the longest substring: " + LongestSubstringKDistinct.findLength("araaci", 1));
        System.out.println("Length of the longest substring: " + LongestSubstringKDistinct.findLength("cbbebi", 3));
    }
}
