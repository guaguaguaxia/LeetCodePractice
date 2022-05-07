package educative.bfs;

import java.util.*;


class ConnectAllSiblings {
    public static void connect(TreeNode2 root) {
        if (root == null)
            return;

        Queue<TreeNode2> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode2 currentNode = null, previousNode = null;
        while (!queue.isEmpty()) {
            currentNode = queue.poll();
            if (previousNode != null)
                previousNode.next = currentNode;
            previousNode = currentNode;

            // insert the children of current node in the queue
            if (currentNode.left != null)
                queue.offer(currentNode.left);
            if (currentNode.right != null)
                queue.offer(currentNode.right);
        }
    }

    public static void main(String[] args) {
        TreeNode2 root = new TreeNode2(12);
        root.left = new TreeNode2(7);
        root.right = new TreeNode2(1);
        root.left.left = new TreeNode2(9);
        root.right.left = new TreeNode2(10);
        root.right.right = new TreeNode2(5);
        ConnectAllSiblings.connect(root);
        root.printTree();
    }
}
