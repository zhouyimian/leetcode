package com.km.leetcode;

import java.util.*;
class ListNode {
	int val;
	ListNode next;
	
	ListNode(int x) {
		val = x;
	}
}
public class Reverse_Linked_List_II {
	public static ListNode reverseBetween(ListNode head, int m, int n) {
		if(m==n)
			return head;
		if(head==null)
            return null;
        Stack<Integer> stack=new Stack<>();
        ListNode temp=head;
        int num=1;
		if (m != 1) {
			while (temp != null && num != m - 1) {
				temp = temp.next;
				num++;
			}
		}
        num=0;
        ListNode temp2;
        if(m!=1)
        	temp2=temp.next;
		else {
			temp2 = temp;
		}
        while(temp2!=null&&num!=(n-m+1)) {
        	stack.push(temp2.val);
        	temp2=temp2.next;
        	num++;
        }
		if (m != 1) {
			while (!stack.isEmpty()) {
				temp.next = new ListNode(stack.pop());
				temp = temp.next;
			}
		}
		else {
			head=new ListNode(stack.pop());
			temp=head;
			while (!stack.isEmpty()) {
				temp.next = new ListNode(stack.pop());
				temp = temp.next;
			}
		}
		temp.next=temp2;
		return head;
	}
	public static void main(String[] args) {
		ListNode root=new ListNode(1);
		root.next=new ListNode(2);
		root.next.next=new ListNode(3);
		root.next.next.next=new ListNode(4);
		root.next.next.next.next=new ListNode(5);
		ListNode s=reverseBetween(root,2,4);
		while(s!=null) {
			System.out.println(s.val);
			s=s.next;
		}
	}
}
