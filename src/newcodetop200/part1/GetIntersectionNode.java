package newcodetop200.part1;

public class GetIntersectionNode {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
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
