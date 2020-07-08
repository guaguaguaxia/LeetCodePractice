package FirstWeek.LinkedList;


/*
* 2020-06-27  First Pass
* 2020-07-08  Second Pass
*
* */


public class ReverseLinkedList206 {
    public static void main(String[] args) {
//        LinkedList<Integer> linkedList = new LinkedList<>();
//        for (int i = 0; i < 5; i++) {
//            linkedList.addFirst(i);
//        }
//        linkedList.add(3, 666);
//        System.out.println(linkedList);
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        ListNode listNode = reverseList(listNode1);
        System.out.println(listNode.val);
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
