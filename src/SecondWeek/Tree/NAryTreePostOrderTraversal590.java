package SecondWeek.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class NAryTreePostOrderTraversal590 {


    public static void main(String[] args) {
        Node Node1 = new Node(1);
        Node Node2 = new Node(2);
        Node Node3 = new Node(3);
        Node Node4 = new Node(4);
        Node Node5 = new Node(5);
        Node Node6 = new Node(6);
        Node Node7 = new Node(7);
        Node Node8 = new Node(8);

        List<Node> nodeList1 = new ArrayList<>();
        nodeList1.add(Node3);
        nodeList1.add(Node4);
        nodeList1.add(Node5);

        List<Node> nodeList2 = new ArrayList<>();
        nodeList2.add(Node6);
        nodeList2.add(Node7);
        nodeList2.add(Node8);


        Node1.children = nodeList1;
//        Node2.children = nodeList2;

        postorder(Node1);

    }


    public static List<Integer> postorder(Node root) {
        LinkedList<Node> stack = new LinkedList<>();
        LinkedList<Integer> output = new LinkedList<>();
        if (root == null) {
            return output;
        }

        stack.add(root);
        while (!stack.isEmpty()) {
            Node node = stack.pollLast();
            output.addFirst(node.val);
            for (Node item : node.children) {
                if (item != null) {
                    stack.add(item);
                }
            }
        }
        return output;
    }


//    public static List<Integer> postorder(Node root) {
//
//        List<Integer> retList = new ArrayList<Integer>();
//        if (root == null) {
//            return retList;
//        }
//
//        Stack<Node> stack = new Stack<Node>();
//        stack.push(root);
//
//        while (!stack.isEmpty()) {
//
//            Node last = stack.lastElement();
//            if (last.children != null && last.children.size() > 0) {
//
//                for (int i = last.children.size() - 1; i >= 0; i--) {
//                    stack.push(last.children.get(i));
//                }
//                // 設成 null，讓下次迴圈遇到的時候會被 pop 出去
//                last.children = null;
//            } else {
//                retList.add(stack.pop().val);
//                System.out.println(stack.pop().val);
//            }
//        }
//
//        return retList;
//    }


    static class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    ;
}
