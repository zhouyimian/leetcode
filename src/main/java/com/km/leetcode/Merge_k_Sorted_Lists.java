package com.km.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Merge_k_Sorted_Lists {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists==null||lists.length==0)
            return null;
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val-o2.val;
            }
        });
        for(ListNode node :lists)
            if(node!=null)
                priorityQueue.add(node);
        ListNode ans = new ListNode(0);
        ListNode temp = ans;
        while(priorityQueue.size()!=0){
            temp.next = priorityQueue.poll();
            temp = temp.next;
            if(temp.next!=null)
                priorityQueue.add(temp.next);
        }
        return ans.next;
    }

    public static void main(String[] args) {
        Merge_k_Sorted_Lists test = new Merge_k_Sorted_Lists();

        ListNode root = new ListNode(-2);
        root.next = new ListNode(-1);
        root.next.next = new ListNode(-1);
        root.next.next.next = new ListNode(-1);
        ListNode[] lists = {root,null};
        ListNode ans = test.mergeKLists(lists);
    }
}
