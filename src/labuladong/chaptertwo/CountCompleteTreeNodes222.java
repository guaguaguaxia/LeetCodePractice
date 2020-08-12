package labuladong.chaptertwo;

public class CountCompleteTreeNodes222 {

    public int countNodes(TreeNode root) {
        TreeNode left = root, right = root;
        // 记录左、右子树的高度
        int hl = 0, hr = 0;
        while (left != null) {
            left = left.left;
            hl++;
        }
        while (right != null) {
            right = right.right;
            hr++;
        }
        // 如果左右子树的高度相同，则是一棵满二叉树
        if (hl == hr) {
            return (int) Math.pow(2, hl) - 1;
        }
        // 如果左右高度不同，则按照普通二叉树的逻辑计算
        return 1 + countNodes(root.left) + countNodes(root.right);
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
