package newcodetop200.part2;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class PathSum {

    List<List<Integer>> ret = new LinkedList<List<Integer>>();
    Stack<Integer> path = new Stack<Integer>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        dfs(root, sum);
        return ret;
    }

    public void dfs(TreeNode root, int sum) {
        if (root == null) {
            return;
        }
        path.add(root.val);
        sum = sum - root.val;
        if (root.left == null && root.right == null && sum == 0) {
            ret.add(new LinkedList<Integer>(path));
        }
        dfs(root.left, sum);
        dfs(root.right, sum);
        path.pop();
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}

