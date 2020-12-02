package interview;

import FirstWeek.LinkedList.ReverseLinkedList206;

import java.util.List;

public class DeleteDuplicates {

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
    }


    public ListNode deleteDuplicates(ListNode head) {
        if (head == null){
            return null;
        }
        ListNode slowNode = head;
        ListNode fastNode = head.next;
        while (fastNode != null){
            if (slowNode.val == fastNode.val){
                slowNode.next = slowNode.next.next;
            }
            slowNode.next = fastNode;
        }
        return slowNode;
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
