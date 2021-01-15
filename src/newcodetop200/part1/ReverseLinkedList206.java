package newcodetop200.part1;


/*
* 2020-06-27  First Pass
* 2020-07-08  Second Pass
* 2020-07-11  Third Pass
* */


public class ReverseLinkedList206 {
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        ListNode listNode = reverseStack(listNode1);
//        ListNode listNode = reverseList(listNode1);

        for (int i = 0; i < 5; i++) {
            if (listNode != null){
                System.out.println(listNode.val);
                listNode = listNode.next;
            }
        }

    }

    /**
     * 反转链表
     **/
    private static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = null;
        ListNode temp = null;
        while (head != null) {
            /*取出链表的下一个节点*/
            temp = head.next;
            /*指向前一个节点*/
            head.next = pre;
            /*保存当前节点*/
            pre = head;
            /*指针后移*/
            head = temp;
        }
        return pre;
    }

    private static ListNode reverseStack(ListNode head) {
        if (head.next == null){
            return head;
        }
        ListNode last = reverseStack(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }
}
