package educative.slidingwindow;

import java.util.*;

// https://leetcode.com/problems/concatenated-words/  472

/*
Given a string and a list of words,
find all the starting indices of substrings in the given string that are a concatenation of all the given words
exactly once without any overlapping of words.
It is given that all words are of the same length.

*/

class WordConcatenation {
    public static List<Integer> findWordConcatenation(String str, String[] words) {
        Map<String, Integer> wordFrequencyMap = new HashMap<>();
        for (String word : words){
            wordFrequencyMap.put(word, wordFrequencyMap.getOrDefault(word, 0) + 1);
        }

        List<Integer> resultIndices = new ArrayList<Integer>();
        int wordsCount = words.length, wordLength = words[0].length();

        for (int i = 0; i <= str.length() - wordsCount * wordLength; i++) {
            Map<String, Integer> wordsSeen = new HashMap<>();
            for (int j = 0; j < wordsCount; j++) {
                int nextWordIndex = i + j * wordLength;
                // get the next word from the string
                String word = str.substring(nextWordIndex, nextWordIndex + wordLength);
                // break if we don't need this word
                if (!wordFrequencyMap.containsKey(word)) {
                    break;
                }
                // add the word to the 'wordsSeen' map
                wordsSeen.put(word, wordsSeen.getOrDefault(word, 0) + 1);

                // no need to process further if the word has higher frequency than required
                if (wordsSeen.get(word) > wordFrequencyMap.getOrDefault(word, 0)){
                    break;
                }

                // store index if we have found all the words
                if (j + 1 == wordsCount) {
                    resultIndices.add(i);
                }
            }
        }

        return resultIndices;
    }

    public static void main(String[] args) {
        List<Integer> result = WordConcatenation.findWordConcatenation("catfoxcat", new String[] { "cat", "fox" });
        System.out.println(result);
//        result = WordConcatenation.findWordConcatenation("catcatfoxfox", new String[] { "cat", "fox" });
//        System.out.println(result);
    }
}
