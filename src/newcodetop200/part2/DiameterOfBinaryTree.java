package newcodetop200.part2;

import newcodetop200.part1.RightSideView;

public class DiameterOfBinaryTree {

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
        return Math.max(Left, Right) + 1;//返回节点深度
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
