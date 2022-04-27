package educative.slidingwindow;

import java.util.*;

// https://leetcode.com/problems/find-all-anagrams-in-a-string/   438

/*
Given a string and a pattern, find all anagrams of the pattern in the given string.

跟educative.slidingwindow.PermutationInAString差不多

*/


class StringAnagrams {
    public static List<Integer> findStringAnagrams(String str, String pattern) {
        int windowStart = 0, matched = 0;
        Map<Character, Integer> charFrequencyMap = new HashMap<>();
        for (char chr : pattern.toCharArray()) {
            charFrequencyMap.put(chr, charFrequencyMap.getOrDefault(chr, 0) + 1);
        }
        // distinct
        List<Integer> resultIndices = new ArrayList<Integer>();
        // our goal is to match all the characters from the map with the current window
        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            char rightChar = str.charAt(windowEnd);
            // decrement the frequency of the matched character
            if (charFrequencyMap.containsKey(rightChar)) {
                charFrequencyMap.put(rightChar, charFrequencyMap.get(rightChar) - 1);
                if (charFrequencyMap.get(rightChar) == 0) {
                    matched++;
                }
            }
            // have we found an anagram?  // distinct
            if (matched == charFrequencyMap.size()) {
                resultIndices.add(windowStart);
            }

            // shrink the window
            if (windowEnd >= pattern.length() - 1) {
                char leftChar = str.charAt(windowStart++);
                if (charFrequencyMap.containsKey(leftChar)) {
                    if (charFrequencyMap.get(leftChar) == 0) {
                        matched--; // before putting the character back, decrement the matched count
                    }
                    // put the character back
                    charFrequencyMap.put(leftChar, charFrequencyMap.get(leftChar) + 1);
                }
            }
        }

        return resultIndices;
    }

    public static void main(String[] args) {
        System.out.println(StringAnagrams.findStringAnagrams("ppqp", "pq"));
        System.out.println(StringAnagrams.findStringAnagrams("abbcabc", "abc"));
    }
}