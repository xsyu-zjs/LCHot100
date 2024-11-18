package 链表.回文链表;

import com.sun.xml.internal.ws.policy.EffectiveAlternativeSelector;

import java.util.List;

/**
 * @description：给你一个单链表的头节点 head ，请你判断该链表是否为回文链表
 * 如果是，返回 true ；否则，返回 false 。
 */
public class Main {
    static class ListNode{
        int val;
        ListNode next;

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
    static boolean solve(ListNode head) {
        // 找中点
        ListNode slow = head, fast = head;
        while(fast.next != null) {
            if(fast.next.next == null) {
                fast = fast.next;
                break;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        slow = slow.next;
        // reverse
        ListNode pre = null;
        while(slow != null) {
            ListNode nextNode = slow.next;
            slow.next = pre;
            pre = slow;
            slow = nextNode;
        }

        while(pre != null) {

            if(pre.val != head.val) return false;
            head = head.next;
            pre = pre.next;
        }
        return true;
    }
    public static void main(String[] args) {
        //ListNode head = new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(1, null))));
        ListNode head = new ListNode(1, new ListNode(2, null));

        boolean res = solve(head);
        System.out.println(res);
    }
}
