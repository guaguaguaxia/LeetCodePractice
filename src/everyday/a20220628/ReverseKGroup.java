package everyday.a20220628;

/**
 * @author guaguaguaxia
 */
public class ReverseKGroup {

    ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        // 区间 [a, b) 包含 k 个待反转元素
        ListNode a = head;
        ListNode b = head;
        for (int i = 0; i < k; i++) {
            // 不足 k 个，不需要反转，base case
            if (b == null) {
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
