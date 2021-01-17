package newcodetop200.part2;

public class MaximumDepthOfBinaryTree104 {
    public static void main(String[] args) {
       TreeNode treeNode1 = new TreeNode(1);
       TreeNode treeNode2 = new TreeNode(2);
       TreeNode treeNode3 = new TreeNode(3);
       TreeNode treeNode4 = new TreeNode(4);
       TreeNode treeNode5 = new TreeNode(5);
       TreeNode treeNode6 = new TreeNode(6);
       TreeNode treeNode7 = new TreeNode(7);
       TreeNode treeNode8 = new TreeNode(8);
       TreeNode treeNode9 = new TreeNode(9);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;
        treeNode5.left = treeNode7;
        treeNode3.right = treeNode6;
        treeNode6.left = treeNode8;
        treeNode6.right = treeNode9;
        int i = maxDepth(treeNode1);
        System.out.println(i);
        /*
         *       1
         *    2     3
         * 4    5     6
         *    7     8   9
         * */
    }

    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left_height = maxDepth(root.left);
        int right_height = maxDepth(root.right);
        return Math.max(left_height, right_height) + 1;
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