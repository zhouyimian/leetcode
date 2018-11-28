package com.km.leetcode;

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}

public class Remove_Duplicates_from_Sorted_List_II {
	public ListNode deleteDuplicates(ListNode head) {
		if(head==null||head.next==null)
			return head;
		ListNode first=head;
		boolean ifequal=head.val==head.next.val;
		while(head!=null&&head.next!=null&&head.next.next!=null) {
			boolean flag=true;
			if(head.next.val==head.next.next.val) {
				ListNode temp=head.next;
				while(temp!=null&&temp.val==head.next.val)
					temp=temp.next;
				head.next=temp;
				flag=false;
			}
			if(flag)
				head=head.next;
		}
		if(first.next==null)
			if(ifequal)
				return null;
			else
				return first;
		if(first.val==first.next.val)
			return first.next.next==null?null:first.next.next;
		if(ifequal)
			return first.next;
		else
			return first;
	}
}
