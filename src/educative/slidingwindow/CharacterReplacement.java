package educative.slidingwindow;

import java.util.*;
/*
Given a string with lowercase letters only, if you are allowed to replace no more than k letters with any letter,
find the length of the longest substring having the same letters after replacement.

问题描述：给一个只包含小写字母的字符串，如果允许替换不超过K个字符串，找出替换后具有相同字母子字符串的最大长度

解决思路：滑动窗口

具体过程：
定义滑动窗口左值windowStart，右值windowEnd，窗口内最大的单词重复数maxRepeatLetterCount，定义maxLength为结果值
定义letterFrequencyMap维护窗口内字符的频率

windowEnd递增，窗口变大
当窗口大小大于maxRepeatLetterCount+k时，说明已经不满足条件
窗口左值右移，同时注意维护letterFrequencyMap
最后maxLength和窗口大小比较，维护maxLength
*/




// https://leetcode-cn.com/problems/longest-repeating-character-replacement/  424

class CharacterReplacement {
    public static int findLength(String str, int k) {
        int windowStart = 0, maxLength = 0, maxRepeatLetterCount = 0;
        Map<Character, Integer> letterFrequencyMap = new HashMap<>();
        // try to extend the range [windowStart, windowEnd]
        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            char rightChar = str.charAt(windowEnd);
            letterFrequencyMap.put(rightChar, letterFrequencyMap.getOrDefault(rightChar, 0) + 1);
            maxRepeatLetterCount = Math.max(maxRepeatLetterCount, letterFrequencyMap.get(rightChar));

            // current window size is from windowStart to windowEnd, overall we have a letter which is
            // repeating 'maxRepeatLetterCount' times, this means we can have a window which has one letter
            // repeating 'maxRepeatLetterCount' times and the remaining letters we should replace.
            // if the remaining letters are more than 'k', it is the time to shrink the window as we
            // are not allowed to replace more than 'k' letters
            if (windowEnd - windowStart + 1 > k + maxRepeatLetterCount) {
                char leftChar = str.charAt(windowStart);
                letterFrequencyMap.put(leftChar, letterFrequencyMap.get(leftChar) - 1);
                windowStart++;
            }

            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(CharacterReplacement.findLength("aabccbb", 2));
//        System.out.println(CharacterReplacement.findLength("abbcb", 1));
//        System.out.println(CharacterReplacement.findLength("abccde", 0));
    }
}
