package SecondWeek.Tree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePreorderTraversal144 {
    public static void main(String[] args) {
        BinaryTreeInorderTraversal94.TreeNode treeNode1 = new BinaryTreeInorderTraversal94.TreeNode(1);
        BinaryTreeInorderTraversal94.TreeNode treeNode2 = new BinaryTreeInorderTraversal94.TreeNode(2);
        BinaryTreeInorderTraversal94.TreeNode treeNode3 = new BinaryTreeInorderTraversal94.TreeNode(3);
        BinaryTreeInorderTraversal94.TreeNode treeNode4 = new BinaryTreeInorderTraversal94.TreeNode(4);
        BinaryTreeInorderTraversal94.TreeNode treeNode5 = new BinaryTreeInorderTraversal94.TreeNode(5);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;
        preorderTraversal(treeNode1);
        /*
         *        1
         *     2     3
         * 4      5
         *
         *
         * */
    }

    public static List<Integer> preorderTraversal(BinaryTreeInorderTraversal94.TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }

    public static void helper(BinaryTreeInorderTraversal94.TreeNode root, List<Integer> res) {
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

    public static class TreeNode {
        int val;
        BinaryTreeInorderTraversal94.TreeNode left;
        BinaryTreeInorderTraversal94.TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
