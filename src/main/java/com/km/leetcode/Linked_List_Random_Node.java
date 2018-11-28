package com.km.leetcode;

import java.util.Random;

public class Linked_List_Random_Node {
	int length=0;
	ListNode head;

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public Linked_List_Random_Node(ListNode head) {
		this.head = head;

		while (head!= null) {
			length++;
			head = head.next;
		}
	}

	/** Returns a random node's value. */
	public int getRandom() {
		ListNode temp=head;
		Random rand = new Random();
		int pos = rand.nextInt(length);
		while (pos != 0) {
			temp = temp.next;
			pos--;
		}
		return temp.val;

	}
}
