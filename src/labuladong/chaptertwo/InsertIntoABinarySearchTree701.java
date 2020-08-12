package labuladong.chaptertwo;

public class InsertIntoABinarySearchTree701 {
    public static void main(String[] args) {

    }

    public static TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }

        if (val > root.val) {
            root.right = insertIntoBST(root.right, val);

        } else if (val < root.val) {
            root.left = insertIntoBST(root.left, val);
        }

        return root;
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
