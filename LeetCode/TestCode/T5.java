package testCode;

public class T5 {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        ListNode head = new ListNode(2);
        head.next = new ListNode(3);
        head.next.next = new ListNode(1);

        System.out.print(insertionSortList(head).val);
    }
    
    public static ListNode insertionSortList(ListNode head) {
        if (null == head || null == head.next) {
            return head;
        }
        ListNode currentNode = head;
        ListNode nextNode = head.next;
        while (null != nextNode) {
            if (currentNode.val > nextNode.val) {
                if (head.val > nextNode.val) {
                    currentNode.next = nextNode.next;
                    nextNode.next = head;
                    head = nextNode;
                    nextNode = currentNode.next;
                } else {
                    ListNode p = head;
                    while (p.next.val < nextNode.val) {
                        p = p.next;
                    }
                    currentNode.next = nextNode.next;
                    nextNode.next = p.next;
                    p.next = nextNode;
                    nextNode = currentNode.next;
                }
            } else {
                currentNode = nextNode;
                nextNode = nextNode.next;
            }
        }
        return head;
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
