package newcodetop200.part3;

import newcodetop200.part2.DiameterOfBinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class IsCompleteTree {

    public boolean isCompleteTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode temp = q.remove();
            /* As soon as a null is encountered,
            now no other non null value could be on the Queue.
            So I check, if there is any I return False, else True.*/
            if (temp == null) {
                while (!q.isEmpty()) {
                    TreeNode temp2 = q.remove();
                    if (temp2 != null) {
                        return false;
                    }
                }
                return true;
            }
            q.add(temp.left);
            q.add(temp.right);
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
