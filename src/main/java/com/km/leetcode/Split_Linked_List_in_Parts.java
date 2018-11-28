package com.km.leetcode;
public class Split_Linked_List_in_Parts {
	public class ListNode {
		int val;
		ListNode next;
		
		ListNode(int x) {
			val = x;
		}
	}

	public ListNode[] splitListToParts(ListNode root, int k) {
		if(root==null)
			return new ListNode[k];
		ListNode[] ans=new ListNode[k];
		ListNode temp=root;
		int sum=1;
		while(temp.next!=null) {
			temp=temp.next;
			sum++;
		}
		temp=root;
		if(sum%k==0) {
			for(int i=0;i<k;i++) {
				ans[i]=new ListNode(temp.val);
				ListNode ln=ans[i];
				temp=temp.next;
				for(int j=1;j<sum/k;j++) {
					ln.next=new ListNode(temp.val);
					ln=ln.next;
					temp=temp.next;
				}
				ln.next=null;
			}
		}
		else {
			for(int i=0;i<sum%k;i++) {
				ans[i]=new ListNode(temp.val);
				ListNode ln=ans[i];
				temp=temp.next;
				for(int j=1;j<sum/k+1;j++) {
					ln.next=new ListNode(temp.val);
					ln=ln.next;
					temp=temp.next;
				}
				ln.next=null;
			}
			if(temp==null)
				return ans;
			for(int i=sum%k;i<k;i++) {
				ans[i]=new ListNode(temp.val);
				ListNode ln=ans[i];
				temp=temp.next;
				for(int j=1;j<sum/k;j++) {
					ln.next=new ListNode(temp.val);
					ln=ln.next;
					temp=temp.next;
				}
				ln.next=null;
			}
		}
		return ans;
	}
}
