package newcodetop200.part1;


public class ReverseKGroup {
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
        ListNode listNode = reverseKGroup(listNode1, 2);
        for (int i = 0; i < 5; i++) {
            if (listNode != null){
                System.out.println(listNode.val);
                listNode = listNode.next;
            }
        }
    }

    static ListNode reverseKGroup(ListNode head, int k) {
        if (head == null){
            return null;
        }
        // 区间 [a, b) 包含 k 个待反转元素
        ListNode a = head;
        ListNode b = head;
        for (int i = 0; i < k; i++) {
            // 不足 k 个，不需要反转，base case
            if (b == null){
                return head;
            }
            b = b.next;
        }
        // 反转前 k 个元素
        ListNode newHead = reverse(a, b);
        // 递归反转后续链表并连接起来
        a.next = reverseKGroup(b, k);
        return newHead;
    }

    /**
     * 反转区间 [a, b) 的元素，注意是左闭右开
     */
    static ListNode reverse(ListNode a, ListNode b) {
        ListNode head = a;
        ListNode pre = null;
        ListNode temp = null;
        // while 终止的条件改一下就行了
        while (head != b) {
            temp = head.next;
            head.next = pre;
            pre = head;
            head = temp;
        }
        // 返回反转后的头结点
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
