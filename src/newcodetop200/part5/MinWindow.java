package newcodetop200.part5;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MinWindow {


    public String minWindow(String s, String t) {
        // HashMap<Character, Integer> map = new HashMap<>();
        int[] map = new int[128];
        for (char c : t.toCharArray()) {
            // map.put(c, map.getOrDefault(c, 0)+1);
            map[c] = map[c] + 1;
        }
        int begin = 0;
        int len = Integer.MAX_VALUE;
        int count = t.length();
        int left = 0, right = 0;
        for (; right < s.length(); right++) {
            char c = s.charAt(right);
            // if (map.containsKey(c)) {
            //     map.replace(c, map.get(c)-1);
            //     if (map.get(c)>=0)
            //         count--;
            // }
            map[c]--;
            if (map[c] >= 0) {
                count--;
            }
            while (count == 0) {
                char lc = s.charAt(left);
                // if (map.containsKey(lc)) {
                //     if (right-left+1<len) {
                //         begin = left;
                //         len = right-left+1;
                //     }
                //     map.replace(lc, map.get(lc)+1);
                //     if (map.get(lc)>0) count++;
                // }
                map[lc]++;
                if (map[lc] > 0) {
                    if (right - left + 1 < len) {
                        begin = left;
                        len = right - left + 1;
                    }
                    count++;
                }
                left++;
            }
        }
        return len == Integer.MAX_VALUE ? "" : s.substring(begin, begin + len);
    }

}
