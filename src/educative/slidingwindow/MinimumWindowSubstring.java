package educative.slidingwindow;

import java.util.*;

// https://leetcode.com/problems/minimum-window-substring/  76
/*
Given a string and a pattern,
find the smallest substring in the given string which has all the character occurrences of the given pattern.

问题描述：给一个字符串和一个匹配字符串，找出满足所有的匹配字符串都出现在字符串中的最小子串

解决思路：滑动窗口

详细过程：
定义滑动窗口左值windowStart，匹配数matched，子字符串最小长度minLength，子字符串开始index subStrStart
定义字符频率hashMap charFrequencyMap

窗口移动，如果charFrequencyMap有该字符，维护charFrequencyMap，注意当charFrequencyMap的字符数量大于等于0时即matched++
为什么是charFrequencyMap的字符数量大于等于0？因为如果有两个字符重复进入会减少至-1

然后在matched数量和匹配字符串相等的情况下尽可能的缩小窗口，维护minLength和subStrStart
字符滑出窗口时注意维护charFrequencyMap，如果是匹配字符串中的字符且减少到了0，则matched--

最后算出最小的字符串
*/

class MinimumWindowSubstring {
    public static String findSubstring(String str, String pattern) {
        int windowStart = 0, matched = 0, minLength = str.length() + 1, subStrStart = 0;
        Map<Character, Integer> charFrequencyMap = new HashMap<>();
        for (char chr : pattern.toCharArray()){
            charFrequencyMap.put(chr, charFrequencyMap.getOrDefault(chr, 0) + 1);
        }

        // try to extend the range [windowStart, windowEnd]
        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            char rightChar = str.charAt(windowEnd);
            if (charFrequencyMap.containsKey(rightChar)) {
                charFrequencyMap.put(rightChar, charFrequencyMap.get(rightChar) - 1);
                // count every matching of a character
                if (charFrequencyMap.get(rightChar) >= 0) {
                    matched++;
                }
            }

            // shrink the window if we can, finish as soon as we remove a matched character
            while (matched == pattern.length()) {
                if (minLength > windowEnd - windowStart + 1) {
                    minLength = windowEnd - windowStart + 1;
                    subStrStart = windowStart;
                }

                char leftChar = str.charAt(windowStart++);
                if (charFrequencyMap.containsKey(leftChar)) {
                    // note that we could have redundant matching characters, therefore we'll decrement the
                    // matched count only when a useful occurrence of a matched character is going out of the window
                    if (charFrequencyMap.get(leftChar) == 0){
                        matched--;
                    }
                    charFrequencyMap.put(leftChar, charFrequencyMap.get(leftChar) + 1);
                }
            }
        }

        return minLength > str.length() ? "" : str.substring(subStrStart, subStrStart + minLength);
    }

    public static void main(String[] args) {
        System.out.println(MinimumWindowSubstring.findSubstring("aabdec", "abc"));
//        System.out.println(MinimumWindowSubstring.findSubstring("aabdec", "abac"));
//        System.out.println(MinimumWindowSubstring.findSubstring("abdbca", "abc"));
//        System.out.println(MinimumWindowSubstring.findSubstring("adcad", "abc"));
//        System.out.println(1 >= 0);
    }
}
