package newcodetop200.part1;

public class GetIntersectionNode {

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        ListNode listNode6 = new ListNode(6);
        ListNode listNode7 = new ListNode(7);
        ListNode listNode8 = new ListNode(8);

        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;


        listNode6.next = listNode7;
        listNode7.next = listNode8;
        listNode8.next = listNode3;

        ListNode intersectionNode = getIntersectionNode(listNode1, listNode6);
        System.out.println(intersectionNode.val);

        /*
        *     1 - 2 - 3 - 4 - 5
        *           /
        * 6 - 7 - 8
        *
        * */
    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode ha = headA, hb = headB;
        while (ha != hb) {
            if (ha != null) {
                ha = ha.next;
            } else {
                ha = headB;
            }
            if (hb != null) {
                hb = hb.next;
            } else {
                hb = headA;
            }
        }
        return ha;
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
