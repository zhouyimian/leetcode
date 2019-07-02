package com.km.problem21_30;

public class Merge_Two_Sorted_Lists {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode newHead = null;
        if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }
        if (l1.val < l2.val) {
            newHead = l1;
            l1 = l1.next;
            newHead.next = null;
        } else {
            newHead = l2;
            l2 = l2.next;
            newHead.next = null;
        }
        ListNode temp = newHead;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                temp.next = l1;
                temp = temp.next;
                l1 = l1.next;
                temp.next = null;
            } else {
                temp.next = l2;
                temp = temp.next;
                l2 = l2.next;
                temp.next = null;
            }
        }
        temp.next = l1 == null ? l2 : l1;
        return newHead;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        ListNode ans = mergeTwoLists(l1,l2);
        while (ans!=null){
            System.out.println(ans.val);
            ans = ans.next;
        }
    }
}
