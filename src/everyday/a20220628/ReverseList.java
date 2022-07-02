package everyday.a20220628;

import labuladong.chaptertwo.ReverseLinkedList206;

/**
 * @author guaguaguaxia
 */
public class ReverseList {
    public static void main(String[] args) {

    }

    private ListNode reverseList(ListNode head) {
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

    public ListNode reverseList2(ListNode head) {
        //递归终止条件是当前为空，或者下一个节点为空
        if (head == null || head.next == null) {
            return head;
        }
        //这里的cur就是最后一个节点，从最后面开始翻转，由上面的base case得出
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

    public class ListNode {
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


