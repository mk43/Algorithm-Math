package testCode;

public class T4 {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        ListNode head = new ListNode(2);
        head.next = new ListNode(3);
        head.next.next = new ListNode(1);

        System.out.print(sortList(head).next.next.val);
    }

    public static ListNode sortList(ListNode head) {
        if (null == head || null == head.next) {
            return head;
        }
        ListNode headStep = head;
        ListNode head2Step = head.next;
        while (null != head2Step && null != head2Step.next) {
            headStep = headStep.next;
            head2Step = head2Step.next.next;
        }
        ListNode l2 = sortList(headStep.next);
        headStep.next = null;
        ListNode l1 = sortList(head);

        ListNode result = new ListNode(0);
        ListNode pointer = result;
        while (null != l1 && null != l2) {
            if (l1.val >= l2.val) {
                result.next = l1;
                l1 = l1.next;
            } else {
                result.next = l2;
                l2 = l2.next;
            }
            result = result.next;
        }
        if (null == l1) {
            result.next = l2;
        } else {
            result.next = l1;
        }
        return pointer.next;
    }

    private static class ListNode {
        public int val;
        public ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
