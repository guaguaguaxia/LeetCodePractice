package labuladong;

import java.util.LinkedList;

public class SerializeAndDeserializeBinaryTree297 {

    public static void main(String[] args) {

    }

    String SEP = ",";
    String NULL = "#";

    /* 主函数，将二叉树序列化为字符串 */
    String preSerialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        preSerialize(root, sb);
        return sb.toString();
    }

    /* 辅助函数，将二叉树存入 StringBuilder */
    void preSerialize(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append(NULL).append(SEP);
            return;
        }

        /****** 前序遍历位置 ******/
        sb.append(root.val).append(SEP);
        /***********************/

        preSerialize(root.left, sb);
        preSerialize(root.right, sb);
    }

    /* 主函数，将字符串反序列化为二叉树结构 */
    TreeNode preDeserialize(String data) {
        // 将字符串转化成列表
        LinkedList<String> nodes = new LinkedList<>();
        for (String s : data.split(SEP)) {
            nodes.addLast(s);
        }
        return preDeserialize(nodes);
    }

    /* 辅助函数，通过 nodes 列表构造二叉树 */
    TreeNode preDeserialize(LinkedList<String> nodes) {
        if (nodes.isEmpty()) return null;

        /****** 前序遍历位置 ******/
        // 列表最左侧就是根节点
        String first = nodes.removeFirst();
        if (first.equals(NULL)) return null;
        TreeNode root = new TreeNode(Integer.parseInt(first));
        /***********************/

        root.left = preDeserialize(nodes);
        root.right = preDeserialize(nodes);

        return root;
    }

    /*--------------------前序遍历------------------------*/

    /* 主函数，将二叉树序列化为字符串 */
    String postSerialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        postSerialize(root, sb);
        return sb.toString();
    }


    /* 辅助函数，将二叉树存入 StringBuilder */
    void postSerialize(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append(NULL).append(SEP);
            return;
        }

        postSerialize(root.left, sb);
        postSerialize(root.right, sb);

        /****** 后序遍历位置 ******/
        sb.append(root.val).append(SEP);
        /***********************/
    }



    /* 主函数，将字符串反序列化为二叉树结构 */
    TreeNode postDeserialize(String data) {
        LinkedList<String> nodes = new LinkedList<>();
        for (String s : data.split(SEP)) {
            nodes.addLast(s);
        }
        return postDeserialize(nodes);
    }

    /* 辅助函数，通过 nodes 列表构造二叉树 */
    TreeNode postDeserialize(LinkedList<String> nodes) {
        if (nodes.isEmpty()) return null;
        // 从后往前取出元素
        String last = nodes.removeLast();
        if (last.equals(NULL)) return null;
        TreeNode root = new TreeNode(Integer.parseInt(last));
        // 限构造右子树，后构造左子树
        root.right = postDeserialize(nodes);
        root.left = postDeserialize(nodes);

        return root;
    }



    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}
