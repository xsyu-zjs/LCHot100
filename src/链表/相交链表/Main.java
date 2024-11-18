package 链表.相交链表;

import java.util.List;

/**
 给你两个单链表的头节点 headA 和 headB ，
 请你找出并返回两个单链表相交的起始节点。
 如果两个链表不存在相交节点，返回 null 。
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

    static ListNode solve(ListNode headA, ListNode headB) {
        int lenA = 0, lenB = 0;
        for(ListNode i = headA; i != null; i = i.next) {
            lenA ++;
        }
        for(ListNode i = headB; i != null; i = i.next) {
            lenB ++;
        }
        while(lenA != lenB) {
            if(lenA > lenB) {
                headA = headA.next;
                lenA --;
            } else {
                headB = headB.next;
                lenB--;
            }
        }
        while(headA.next != null && headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }
    /*
        复杂度 O(n) 10min
     */
    public static void main(String[] args) {
        ListNode node8 = new ListNode(8, new ListNode(4, new ListNode(5, null)));
        ListNode headA = new ListNode(4, new ListNode(1, node8));
        ListNode headB = new ListNode(5, new ListNode(6, new ListNode(1, node8)));
        ListNode res = solve(headA, headB);
        System.out.println(res == null ? "null" : res.val);
    }
}

/*
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode pA = headA, pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }
}

作者：力扣官方题解
链接：https://leetcode.cn/problems/intersection-of-two-linked-lists/solutions/811625/xiang-jiao-lian-biao-by-leetcode-solutio-a8jn/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
