package newcodetop200.part1;

import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestSubstring {

    public static void main(String[] args) {
//        String s = "abcbbcbb";
        String s = "pwwkew";
        int i = lengthOfLongestSubstring1(s);
        System.out.println(i);
    }


    public static int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        HashMap<Character, Integer> window = new HashMap<Character, Integer>();
        int left = 0;
        int right = 0;
        int res = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            window.put(c, window.getOrDefault(c, 0) + 1);
            while (window.get(c) > 1) {
                char d = s.charAt(left);
                left++;
                Integer integer = window.get(d);
                window.put(d, integer - 1);
            }
            res = Math.max(res, right - left);
        }
        return res;
    }

    public static int lengthOfLongestSubstring1(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int end = 0, start = 0; end < n; end++) {
            char alpha = s.charAt(end);
            if (map.containsKey(alpha)) {
                start = Math.max(map.get(alpha), start);
            }
            ans = Math.max(ans, end - start + 1);
            map.put(s.charAt(end), end + 1);
        }
        return ans;
    }


//    public static int lengthOfLongestSubstring(String s) {
//        if (s.length() == 0) {
//            return 0;
//        }
//        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
//        int max = 0;
//        int left = 0;
//        for (int i = 0; i < s.length(); i++) {
//            if (map.containsKey(s.charAt(i))) {
//                left = Math.max(left, map.get(s.charAt(i)) + 1);
//            }
//            map.put(s.charAt(i), i);
//            max = Math.max(max, i - left + 1);
//        }
//        return max;
//    }

}
