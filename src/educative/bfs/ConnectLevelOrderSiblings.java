package educative.bfs;

import java.util.*;


class ConnectLevelOrderSiblings {
    public static void connect(TreeNode2 root) {
        if (root == null)
            return;

        Queue<TreeNode2> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode2 previousNode = null;
            int levelSize = queue.size();
            // connect all nodes of this level
            for (int i = 0; i < levelSize; i++) {
                TreeNode2 currentNode = queue.poll();
                if (previousNode != null){
                    previousNode.next = currentNode;
                }
                previousNode = currentNode;

                // insert the children of current node in the queue
                if (currentNode.left != null){
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null){
                    queue.offer(currentNode.right);
                }
            }
        }
    }

    public static void main(String[] args) {
        TreeNode2 root = new TreeNode2(12);
        root.left = new TreeNode2(7);
        root.right = new TreeNode2(1);
        root.left.left = new TreeNode2(9);
        root.right.left = new TreeNode2(10);
        root.right.right = new TreeNode2(5);
        ConnectLevelOrderSiblings.connect(root);
        System.out.println("Level order traversal using 'next' pointer: ");
        root.printLevelOrder();
    }
}
