package educative.slidingwindow;

import java.util.*;


/*
educative  5
Given a string, find the length of the longest substring, which has all distinct characters.

问题描述，给出一个字符串，找出其中最长的不重复子串

解决思路：滑动窗口

具体过程：
定义滑动窗口的左值windowStart，右值windowEnd
定义charIndexMap来记录每个字符的下标值
定义结果值maxLength

在窗口移动的过程中把字符放入charIndexMap，
如果在charIndexMap中已有该字符，则把窗口左值windowStart的置为上一次该字符出现的后面一个值
将当前窗口大小和maxLength对比，维护大小

*/

// https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/  3
class NoRepeatSubstring {
    public static int findLength(String str) {
        int windowStart = 0, maxLength = 0;
        Map<Character, Integer> charIndexMap = new HashMap<>();
        // try to extend the range [windowStart, windowEnd]
        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            char rightChar = str.charAt(windowEnd);
            // if the map already contains the 'rightChar', shrink the window from the beginning so that
            // we have only one occurrence of 'rightChar'
            if (charIndexMap.containsKey(rightChar)) {
                // this is tricky; in the current window, we will not have any 'rightChar' after its previous index
                // and if 'windowStart' is already ahead of the last index of 'rightChar', we'll keep 'windowStart'
                windowStart = Math.max(windowStart, charIndexMap.get(rightChar) + 1);
            }
            charIndexMap.put(rightChar, windowEnd); // insert the 'rightChar' into the map
            maxLength = Math.max(maxLength, windowEnd - windowStart + 1); // remember the maximum length so far
        }

        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println("Length of the longest substring: " + NoRepeatSubstring.findLength("aabccbb"));
        System.out.println("Length of the longest substring: " + NoRepeatSubstring.findLength("abbbb"));
        System.out.println("Length of the longest substring: " + NoRepeatSubstring.findLength("abccde"));
    }
}
