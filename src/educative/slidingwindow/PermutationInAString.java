package educative.slidingwindow;

import java.util.*;

// https://leetcode.com/problems/permutation-in-string/  567

/*
Given a string and a pattern, find out if the string contains any permutation of the pattern.

问题描述：给定一个字符串和一个匹配字符串，判断字符串里是否有匹配字符串的某个全排列

解决方法：滑动窗口

具体过程：
定义窗口的左值windowStart，右值windowEnd
定义hashMap charFrequencyMap 记录匹配字符串中每个字符的频率，map此方法中的实际含义为「还需要匹配什么字符」
定义matched表示已匹配的数量

窗口移动的时候，如果窗口右值在charFrequencyMap中则表示有匹配到的，charFrequencyMap中相应的字符频率减一，matched++，
如果窗口大小大于匹配字符串减一，则窗口左值增加。如果左边滑出去的值是charFrequencyMap中的，此字符则需要+1
如果移除的字符串是完全匹配的，则需要matched--

charFrequencyMap的元素不会移除
*/


class PermutationInAString {
    public static boolean findPermutation(String str, String pattern) {
        int windowStart = 0, matched = 0;
        Map<Character, Integer> charFrequencyMap = new HashMap<>();
        for (char chr : pattern.toCharArray()) {
            charFrequencyMap.put(chr, charFrequencyMap.getOrDefault(chr, 0) + 1);
        }

        // our goal is to match all the characters from the 'charFrequencyMap' with the current window
        // try to extend the range [windowStart, windowEnd]
        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            char rightChar = str.charAt(windowEnd);
            if (charFrequencyMap.containsKey(rightChar)) {
                // decrement the frequency of the matched character
                charFrequencyMap.put(rightChar, charFrequencyMap.get(rightChar) - 1);
                // character is completely matched
                if (charFrequencyMap.get(rightChar) == 0) {
                    matched++;
                }
            }

            if (matched == charFrequencyMap.size()) {
                return true;
            }
            // shrink the window by one character
            if (windowEnd >= pattern.length() - 1) {
                char leftChar = str.charAt(windowStart++);
                if (charFrequencyMap.containsKey(leftChar)) {
                    if (charFrequencyMap.get(leftChar) == 0) {
                        matched--; // before putting the character back, decrement the matched count
                    }
                    // put the character back for matching
                    charFrequencyMap.put(leftChar, charFrequencyMap.get(leftChar) + 1);
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println("Permutation exist: " + PermutationInAString.findPermutation("oidbcaf", "abc"));
        System.out.println("Permutation exist: " + PermutationInAString.findPermutation("odicf", "dc"));
        System.out.println("Permutation exist: " + PermutationInAString.findPermutation("bcdxabcdy", "bcdyabcdx"));
        System.out.println("Permutation exist: " + PermutationInAString.findPermutation("aaacb", "abc"));
    }
}
