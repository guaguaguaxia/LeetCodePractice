package SecondWeek.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/*
* 2020-07-18  check
* 2020-07-19  堆
*
* */

public class BinaryTreePreorderTraversal144 {
    public static void main(String[] args) {
       TreeNode treeNode1 = new TreeNode(1);
       TreeNode treeNode2 = new TreeNode(2);
       TreeNode treeNode3 = new TreeNode(3);
       TreeNode treeNode4 = new TreeNode(4);
       TreeNode treeNode5 = new TreeNode(5);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;
//        preorderTraversal1(treeNode1);
        preorderTraversal2(treeNode1);

        /*
         *        1
         *     2     3
         * 4      5
         *
         *
         * */
    }

    public static List<Integer> preorderTraversal1(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }

    public static void helper(TreeNode root, List<Integer> res) {
        if (root != null) {
            res.add(root.val);
            if (root.left != null) {
                helper(root.left, res);
            }
            System.out.println(root.val);
            if (root.right != null) {
                helper(root.right, res);
            }
        }
    }


    public static List<Integer> preorderTraversal2(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        LinkedList<Integer> output = new LinkedList<>();
        if (root == null) {
            return output;
        }

        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pollLast();
            output.add(node.val);
            System.out.println(node.val);
            if (node.right != null) {
                stack.add(node.right);
            }
            if (node.left != null) {
                stack.add(node.left);
            }
        }
        return output;
    }



    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
