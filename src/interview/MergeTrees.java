package interview;

import FourthWeek.BinaryTreeLevelOrderTraversal102;

public class MergeTrees {

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode5 = new TreeNode(5);
        treeNode1.left = treeNode3;
        treeNode1.right = treeNode2;
        treeNode3.left = treeNode5;


        TreeNode treeNodeTwo1 = new TreeNode(1);
        TreeNode treeNodeTwo2 = new TreeNode(2);
        TreeNode treeNodeTwo3 = new TreeNode(3);
        TreeNode treeNodeTwo4 = new TreeNode(4);
        TreeNode treeNodeTwo7 = new TreeNode(7);


        treeNodeTwo2.left = treeNodeTwo1;
        treeNodeTwo2.right = treeNodeTwo3;
        treeNodeTwo1.right = treeNodeTwo4;
        treeNodeTwo3.right = treeNodeTwo7;


        /*
         *        1
         *     3     2
         *  5
         *
         *
         * */
    }


    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null || t2 == null) {
            return t1 == null ? t2 : t1;
        }
        return dfs(t1, t2);
    }

    TreeNode dfs(TreeNode r1, TreeNode r2) {
        // 如果 r1和r2中，只要有一个是null，函数就直接返回
        if (r1 == null || r2 == null) {
            return r1 == null ? r2 : r1;
        }
        //让r1的值 等于  r1和r2的值累加，再递归的计算两颗树的左节点、右节点
        r1.val += r2.val;
        r1.left = dfs(r1.left, r2.left);
        r1.right = dfs(r1.right, r2.right);
        return r1;
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
