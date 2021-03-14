package CheckInEveryDay.a20210313;

public class AddTwoNumbers {

    public static void main(String[] args) {
        ListNode listNode3 = new ListNode(3);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode1 = new ListNode(1);

        listNode3.next = listNode2;
        listNode2.next = listNode1;

        ListNode listNode6 = new ListNode(6);
        ListNode listNode5 = new ListNode(5);
        ListNode listNode4 = new ListNode(4);

        listNode6.next = listNode5;
        listNode5.next = listNode4;

        AddTwoNumbers add = new AddTwoNumbers();
        ListNode listNode = add.addTwoNumbers(listNode3, listNode6);

        while (listNode != null){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode pre = new ListNode(0);
        ListNode cur = pre;
        int carry = 0;
        while(l1 != null || l2 != null) {
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;
            int sum = x + y + carry;

            /*进位*/
            carry = sum > 9 ? 1 : 0;
            /*相加之后的单数*/
            sum = sum % 10;
            cur.next = new ListNode(sum);

            cur = cur.next;
            if(l1 != null){
                l1 = l1.next;
            }
            if(l2 != null){
                l2 = l2.next;
            }
        }
        if(carry == 1) {
            cur.next = new ListNode(carry);
        }
        return pre.next;
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
