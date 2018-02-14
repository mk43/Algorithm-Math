package testCode;

public class T9 {

    public static final void main(String args[]) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = head;
//        head.next.next = new ListNode(3);
//        head.next.next.next = head;
        System.out.print(detectCycle(head).val);
    }

    public static ListNode detectCycle(ListNode head) {
        if (null == head || null == head.next) {
            return null;
        }
        if (head.next == head) {
            return head;
        }
        ListNode tempNode = head.next;
        head.next = null;
        ListNode result = detectCycle(tempNode);
        head.next = tempNode;
        if (null == result) {
            ListNode currentPtr = head.next;
            while (null != currentPtr) {
                if (currentPtr == head) {
                    result = head;
                    break;
                }
                currentPtr = currentPtr.next;
            }
        }
        return result;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
