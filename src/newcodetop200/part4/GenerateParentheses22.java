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
        if (n == 0) {
            return null;
        }
        // 记录所有合法的括号组合
        List<String> res = new ArrayList<>();
        // 回溯过程中的路径
        StringBuilder track = new StringBuilder();
        // 可用的左括号和右括号数量初始化为 n
        backtrack(n, n, track, res);
        return res;
    }

    // 可用的左括号数量为 left 个，可用的右括号数量为 rgiht 个
    void backtrack(int left, int right,
                   StringBuilder track, List<String> res) {
        // 若左括号剩下的多，说明不合法
        if (right < left) {
            return;
        }
        // 数量小于 0 肯定是不合法的
        if (left < 0 || right < 0) {
            return;
        }
        // 当所有括号都恰好用完时，得到一个合法的括号组合
        if (left == 0 && right == 0) {
            res.add(track.toString());
            return;
        }

        // 尝试放一个左括号
        track.append('('); // 选择
        backtrack(left - 1, right, track, res);
        track.deleteCharAt(track.length() - 1); // 撤消选择

        // 尝试放一个右括号
        track.append(')'); // 选择
        backtrack(left, right - 1, track, res);
        track.deleteCharAt(track.length() - 1); // 撤消选择
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
