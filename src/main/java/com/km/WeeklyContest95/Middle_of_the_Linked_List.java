package com.km.WeeklyContest95;

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}

public class Middle_of_the_Linked_List {
	public static ListNode middleNode(ListNode head) {
		ListNode temp=head;
		int count=1;
		while(temp.next!=null) {
			temp=temp.next;
			count++;
		}
		temp=head;
		for(int i=1;i<=count/2;i++) {
			temp=temp.next;
		}
		return temp;
	}
	public static void main(String[] args) {
		ListNode root=new ListNode(1);
		root.next=new ListNode(2);
		//root.next.next=new ListNode(3);
		//root.next.next.next=new ListNode(4);
		System.out.println(middleNode(root).val);
	}
}
