package everyday.a20220628;

import java.util.HashMap;
import java.util.Map;

/**
 * @author guaguaguaxia
 */
public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        Map<Character, Integer> charIndexMap = new HashMap<>();
        for (int windowStart = 0, windowEnd = 0; windowEnd < s.length(); windowEnd++) {
            char rightChar = s.charAt(windowEnd);
            if (charIndexMap.containsKey(rightChar)) {
                windowStart = Math.max(windowStart, charIndexMap.get(rightChar) + 1);
            }
            charIndexMap.put(rightChar, windowEnd);
            res = Math.max(res, windowEnd - windowStart + 1);
        }
        return res;
    }
}
