package educative.twopointers;

public class PartitionListNode {
    public static ListNode partition(ListNode head, int x) {
        ListNode small = new ListNode(0);
        ListNode smallHead = small;
        ListNode large = new ListNode(0);
        ListNode largeHead = large;
        while (head != null) {
            if (head.val < x) {
                small.next = head;
                small = small.next;
            } else {
                large.next = head;
                large = large.next;
            }
            head = head.next;
        }
        large.next = null;
        small.next = largeHead.next;
        return smallHead.next;
    }

    public static void main(String[] args) {
        ListNode node2 = new ListNode(2,null);
        ListNode node5 = new ListNode(5,node2);
        ListNode node6 = new ListNode(6,node5);
        ListNode node3 = new ListNode(3,node6);
        ListNode node4 = new ListNode(4,node3);
        ListNode node1 = new ListNode(1,node4);
        ListNode partition = partition(node1, 3);
        while (partition != null){
            System.out.println(partition.val);
            partition = partition.next;
        }
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
