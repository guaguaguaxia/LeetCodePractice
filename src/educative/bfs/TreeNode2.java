package educative.bfs;

class TreeNode2 {
    int val;
    TreeNode2 left;
    TreeNode2 right;
    TreeNode2 next;

    TreeNode2(int x) {
        val = x;
        left = right = next = null;
    }

    // level order traversal using 'next' pointer
    public void printLevelOrder() {
        TreeNode2 nextLevelRoot = this;
        while (nextLevelRoot != null) {
            TreeNode2 current = nextLevelRoot;
            nextLevelRoot = null;
            while (current != null) {
                System.out.print(current.val + " ");
                if (nextLevelRoot == null) {
                    if (current.left != null)
                        nextLevelRoot = current.left;
                    else if (current.right != null)
                        nextLevelRoot = current.right;
                }
                current = current.next;
            }
            System.out.println();
        }
    }

    public void printTree() {
        TreeNode2 current = this;
        System.out.print("Traversal using 'next' pointer: ");
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
    }
};
