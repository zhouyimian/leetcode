package com.km.leetcode;

public class Construct_String_from_Binary_Tree {
	public class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	}
	StringBuilder ans=new StringBuilder();
	public String tree2str(TreeNode t) {
		if(t==null)
			return "";
		else {
			if(t.left==null&&t.right==null) {
				ans.append(t.val);
			}
			else if(t.left!=null&&t.right==null) {
				ans.append(t.val + "(");
				add(t.left);
				ans.append(")");
			}
			else{
				ans.append(t.val + "(");
				add(t.left);
				ans.append(")(");
				add(t.right);
				ans.append(")");
			}
		}
		return new String(ans);
    }
	void add(TreeNode t) {
		if(t==null) {
			return;
		}
		else {
			if(t.left==null&&t.right==null) {
				ans.append(t.val);
			}
			else if(t.left!=null&&t.right==null) {
				ans.append(t.val + "(");
				add(t.left);
				ans.append(")");
			}
			else{
				ans.append(t.val + "(");
				add(t.left);
				ans.append(")(");
				add(t.right);
				ans.append(")");
			}
		}
	}
}
