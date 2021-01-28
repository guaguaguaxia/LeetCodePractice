package newcodetop200.part2;


import newcodetop200.part1.PreorderTraversal;

public class DiameterOfBinaryTree {

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
        DiameterOfBinaryTree d = new DiameterOfBinaryTree();
        int i = d.diameterOfBinaryTree(treeNode1);
        System.out.println(i);
        /*
         *       1
         *    2     3
         * 4    5     6
         *    7     8   9
         * */


    }


    int maxd = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return maxd;
    }

    public int depth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int Left = depth(node.left);
        int Right = depth(node.right);
        //将每个节点最大直径(左子树深度+右子树深度)当前最大值比较并取大者
        maxd = Math.max(Left + Right, maxd);
        //返回节点深度
        return Math.max(Left, Right) + 1;
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
