package interview;

import java.util.HashMap;
/*剑指offer50*/
public class FirstUniqChar {
    public char firstUniqChar(String s) {
        HashMap<Character, Boolean> dic = new HashMap<>();
        char[] sc = s.toCharArray();
        for(char c : sc){
            dic.put(c, !dic.containsKey(c));
        }
        for(char c : sc){
            if(dic.get(c)) {
                return c;
            }

        }
        return ' ';
    }

}
