package newcodetop200.part1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigzagLevelOrder {

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
        List<List<Integer>> lists = zigzagLevelOrder(treeNode1);
        System.out.println(lists);
        /*
         *       1
         *    2     3
         * 4    5     6
         *    7     8   9
         * */
    }

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;
        //创建队列，保存节点
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);//先把节点加入到队列中
        boolean leftToRight = true;//第一步先从左边开始打印
        while (!queue.isEmpty()) {
            //记录每层节点的值
            List<Integer> level = new ArrayList<>();
            //统计这一层有多少个节点
            int count = queue.size();
            //遍历这一层的所有节点，把他们全部从队列中移出来，顺便
            //把他们的值加入到集合level中，接着再把他们的子节点（如果有）
            //加入到队列中
            for (int i = 0; i < count; i++) {
                //poll移除队列头部元素（队列在头部移除，尾部添加）
                TreeNode node = queue.poll();
                //判断是从左往右打印还是从右往左打印。
                if (leftToRight) {
                    //如果从左边打印，直接把访问的节点值加入到列表level的末尾即可
                    level.add(node.val);
                } else {
                    //如果是从右边开始打印，每次要把访问的节点值
                    //加入到列表的最前面
                    level.add(0, node.val);
                }
                //左右子节点如果不为空会被加入到队列中
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
            }
            //把这一层的节点值加入到集合res中
            res.add(level);
            //改变下次访问的方向
            leftToRight = !leftToRight;
        }
        return res;
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
