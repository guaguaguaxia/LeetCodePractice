package educative.slidingwindow;

import java.util.*;

// https://leetcode.com/problems/permutation-in-string/  567


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
