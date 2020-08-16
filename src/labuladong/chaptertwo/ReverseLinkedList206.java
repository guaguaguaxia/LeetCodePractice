package labuladong.chaptertwo;


/*
* 2020-06-27  First Pass
* 2020-07-08  Second Pass
* 2020-07-11  Third Pass
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
        ListNode listNode = reverseList1(listNode1);
        System.out.println(listNode.val);
    }

    /**
     * 反转链表
     **/
    private static ListNode reverseList1(ListNode head) {
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

    public static ListNode reverseList2(ListNode head) {
        //递归终止条件是当前为空，或者下一个节点为空
        if(head==null || head.next==null) {
            return head;
        }
        //这里的cur就是最后一个节点
        ListNode cur = reverseList2(head.next);
        //这里请配合动画演示理解
        //如果链表是 1->2->3->4->5，那么此时的cur就是5
        //而head是4，head的下一个是5，下下一个是空
        //所以head.next.next 就是5->4
        head.next.next = head;
        //防止链表循环，需要将head.next设置为空
        head.next = null;
        //每层递归函数都返回cur，也就是最后一个节点
        return cur;
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
