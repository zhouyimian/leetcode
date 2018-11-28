package com.km.WeeklyContest80;

public class Linked_List_Components {
	public class ListNode {
		int val;
		ListNode next;
		
		ListNode(int x) {
			val = x;
		}
	}
	public int numComponents(ListNode head, int[] G) {
		int ans=0;
		int[][] vis=new int[10010][3];
		ListNode temp=head;
		int before=temp.val;
		int after=0;
		while(temp!=null) {
			if(temp==head) {
				vis[temp.val][2]=10001;
				vis[10001][0]=1;
			}
			if(temp.next!=null) {
				after=temp.next.val;
			}
			vis[temp.val][0]=1;                //1代表有这个点并且未被访问  2代表这个点已经被访问过了
			if(temp!=head) {
				vis[temp.val][2]=before;       //值为temp.val的点的前一个节点的值
			}
			if(temp.next!=null) {
				vis[temp.val][1]=after;
				before=temp.val;
			}
			if(temp.next==null) {
				vis[temp.val][1]=10001;
			}
			temp=temp.next;
		}
		for(int i=0;i<G.length;i++){
			System.out.println(vis[G[i]][0]+"   "+vis[vis[G[i]][1]][0]+"  "+vis[vis[G[i]][2]][0]);
			if(vis[G[i]][0]==2)
				continue;
			else if(vis[G[i]][0]==1&&vis[vis[G[i]][1]][0]==2&&vis[vis[G[i]][2]][0]==2)
				ans--;
			else if(vis[G[i]][0]==1&&vis[vis[G[i]][1]][0]==1&&vis[vis[G[i]][2]][0]==1) {
				ans++;
			}
			vis[G[i]][0]=2;
		}
		return ans;
	}
}
