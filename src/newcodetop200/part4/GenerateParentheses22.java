package newcodetop200.part4;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses22 {
    ArrayList[] cache = new ArrayList[100];

    public static void main(String[] args) {
        GenerateParentheses22 ob = new GenerateParentheses22();
        List<String> generate = ob.generateParenthesis(3);
        generate.forEach(System.out::println);

    }

    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList();
        backtrack(ans, new StringBuilder(), 0, 0, n);
        return ans;
    }

    public void backtrack(List<String> ans, StringBuilder cur, int open, int close, int max){
        if (cur.length() == max * 2) {
            ans.add(cur.toString());
            return;
        }

        if (open < max) {
            backtrack(ans, cur.append("("), open+1, close, max);
            cur.deleteCharAt(cur.length() - 1);
        }
        if (open > close) {
            backtrack(ans, cur.append(")"), open, close+1, max);
            cur.deleteCharAt(cur.length() - 1);
        }
    }


//    public List<String> generate(int n) {
//        if (cache[n] != null) {
//            return cache[n];
//        }
//        ArrayList<String> ans = new ArrayList();
//        if (n == 0) {
//            ans.add("");
//        } else {
//            for (int c = 0; c < n; ++c) {
//                for (String left : generate(c)) {
//                    for (String right : generate(n - 1 - c)) {
//                        ans.add("(" + left + ")" + right);
//                    }
//                }
//            }
//        }
//        cache[n] = ans;
//        return ans;
//    }
//
//    public List<String> generateParenthesis(int n) {
//        return generate(n);
//    }

}
