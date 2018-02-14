package testCode;

public class T8 {

    static class  ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static final void main(String args[]) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        reorderList(head);
        System.out.print(head.val + " " + head.next.next.next.val);
    }

    public static void reorderList(ListNode head) {
        if (null == head || null == head.next) {
            return;
        }
        ListNode slowPtr = head;
        ListNode fastPtr = head;
        while (null != fastPtr.next && null != fastPtr.next.next) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }

        ListNode startPtr = slowPtr.next;
        ListNode headPtr = startPtr;
        slowPtr.next = null;
        while (null != headPtr.next) {
            ListNode tempPtr = headPtr.next;
            headPtr.next = tempPtr.next;
            tempPtr.next = startPtr;
            startPtr = tempPtr;
        }

        ListNode l1 = head;
        ListNode l2 = startPtr;
        while (null != l1 && null != l2) {
            ListNode tempPtr = l2;
            l2 = l2.next;
            tempPtr.next = l1.next;
            l1.next = tempPtr;
            l1 = l1.next.next;
        }
    }

}
