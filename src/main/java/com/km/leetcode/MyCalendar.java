package com.km.leetcode;

import java.util.*;

public class MyCalendar {
	//���Խⷨ
	/*Set<int[]> set=new HashSet<>();
	public MyCalendar() {
		
	}

	public boolean book(int start, int end) {
		Iterator it=set.iterator();
		while(it.hasNext()) {
			int[] temp=(int[]) it.next();
			int s=temp[0];
			int e=temp[1];
			if(start>=e||end<=s)
				continue;
			else
				return false;
		}
		int[] temp=new int[2];
		temp[0]=start;
		temp[1]=end;
		set.add(temp);
		return true;
	}*/
	//�����������ⷨ
	class node{
		public int start;
		public int end;
		public node left;
		public node right;
		
		public node(int start,int end) {
			this.start=start;this.end=end;this.left=null;this.right=null;
		}
	}
	node root=null;
	public MyCalendar() {
	}

	public boolean book(int start, int end) {
		if(root==null) {
			root=new node(start,end);
			return true;
		}
		else {
			node temp=root;
			while(temp!=null) {
				if(end<=temp.start) {
					if(temp.left!=null)
						temp=temp.left;
					else {
						node n=new node(start,end);
						temp.left=n;
						break;
					}
				}
				else if(start>=temp.end) {
					if(temp.right!=null)
						temp=temp.right;
					else {
						node n=new node(start,end);
						temp.right=n;
						break;
					}
				}
				else {
					return false;
				}
			}
		}
		return true;

	}
}
