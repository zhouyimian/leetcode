package com.km.leetcode;

public class Remove_Nth_Node_From_End_of_List {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp = head,first = head;
        for(int i = 0;i<n;i++)
            first = first.next;
        if(first==null)
            return head.next;
        while(first.next!=null){
            first = first.next;
            temp = temp.next;
        }
        temp.next = temp.next.next;
        return head;
    }
}
