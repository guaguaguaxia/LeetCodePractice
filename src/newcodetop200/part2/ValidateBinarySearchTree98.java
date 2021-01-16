package newcodetop200.part2;

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


    static boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    /* 限定以 root 为根的子树节点必须满足 max.val > root.val > min.val */
    static boolean isValidBST(TreeNode root, TreeNode min, TreeNode max) {
        // base case
        if (root == null) {
            return true;
        }
        // 若 root.val 不符合 max 和 min 的限制，说明不是合法 BST
        if (min != null && root.val <= min.val) {
            return false;
        }
        if (max != null && root.val >= max.val) {
            return false;
        }
        // 限定左子树的最大值是 root.val，右子树的最小值是 root.val
        return isValidBST(root.left, min, root)
                && isValidBST(root.right, root, max);
    }


    //    public static boolean isValidBST(TreeNode root) {
//        Stack<TreeNode> stack = new Stack();
//        double inorder = -Double.MAX_VALUE;
//
//        while (!stack.isEmpty() || root != null) {
//            while (root != null) {
//                stack.push(root);
//                root = root.left;
//            }
//            root = stack.pop();
//            // 如果中序遍历得到的节点的值小于等于前一个 inorder，说明不是二叉搜索树
//            if (root.val <= inorder) {
//                return false;
//            }
//            inorder = root.val;
//            root = root.right;
//        }
//        return true;
//    }
//
//
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}
