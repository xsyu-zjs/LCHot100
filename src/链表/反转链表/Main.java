package 链表.反转链表;

/**
 * @description：给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 *
 */
public class Main {
    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    static ListNode solve(ListNode head) {
        ListNode hair = new ListNode(-1, head);
        ListNode pre = null;
        while(head != null) {
            ListNode nextNode = head.next;
            head.next = pre;
            pre = head;
            head = nextNode;
        }
        return pre;
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, null)))));
        ListNode res = solve(head);
        System.out.println(res.val);
        while(res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }
}
