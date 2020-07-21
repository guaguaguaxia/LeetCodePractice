package SecondWeek.Recursive;

import java.util.Stack;

public class ValidateBinarySearchTree98 {

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode7 = new TreeNode(7);

        treeNode4.left = treeNode3;
        treeNode3.left = treeNode2;
        treeNode2.left = treeNode1;

        treeNode4.right = treeNode5;
        treeNode5.right = treeNode6;
        treeNode6.right = treeNode7;

        boolean validBST = isValidBST(treeNode4);
        System.out.println(validBST);

        /*
         *            4
         *         3     5
         *      2           6
         *   1                 7
         *
         * */
    }

    public static boolean isValidBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack();
        double inorder = -Double.MAX_VALUE;

        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            // 如果中序遍历得到的节点的值小于等于前一个 inorder，说明不是二叉搜索树
            if (root.val <= inorder) {
                return false;
            }
            inorder = root.val;
            root = root.right;
        }
        return true;
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
