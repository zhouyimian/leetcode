package com.km.leetcode;

import java.util.*;

public class Copy_List_with_Random_Pointer {
	class RandomListNode {
		int label;
		RandomListNode next, random;

		RandomListNode(int x) {
			this.label = x;
		}
	};

	public RandomListNode copyRandomList(RandomListNode head) {
		if(head==null)
			return null;
		Map<RandomListNode,RandomListNode> map=new HashMap<>();
		RandomListNode root=new RandomListNode(head.label);
		map.put(head, root);
		RandomListNode temp=head.next;
		RandomListNode temp_copy=root;
		while(temp!=null) {
			temp_copy.next=new RandomListNode(temp.label);
			temp_copy=temp_copy.next;
			map.put(temp,temp_copy);
			temp=temp.next;
		}
		temp=head;
		temp_copy=root;
		while(temp!=null) {
			temp_copy.random=map.get(temp.random);
			temp=temp.next;
			temp_copy=temp_copy.next;
		}
		return root;
	}
}
