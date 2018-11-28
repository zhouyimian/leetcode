package com.km.leetcode;

public class Serialize_and_Deserialize_BST {

	static StringBuilder ans = new StringBuilder();
	public static String serialize(TreeNode root) {
		if (root == null)
			return "";
		else {
			if (root.left == null && root.right == null) {
				ans.append(root.val);
			} else if (root.left != null && root.right == null) {
				ans.append(root.val + "(");
				add(root.left);
				ans.append(")");
			} else {
				ans.append(root.val + "(");
				add(root.left);
				ans.append(")(");
				add(root.right);
				ans.append(")");
			}
		}
		return new String(ans);
	}
	
	public static TreeNode deserialize(String data) {
		if(data.equals(""))
			return null;
		else {
			StringBuilder sb=new StringBuilder();
			int i=0,pos;
			char ch;
			while(i<=data.length()-1&&(ch=(char) data.charAt(i++))!='(') {
				sb.append(ch);
			}
			pos=i;
			TreeNode root=new TreeNode(Integer.parseInt(new String(sb)));
			int count=1;
			while(i<data.length()) {
				ch=(char) data.charAt(i++);
				if(ch=='(')
					count++;
				else if(ch==')') {
					count--;
					if(count==0) {
						if(i-pos==1)
							root.left=null;
						else
							root.left = buildTree(data.substring(pos, i-1));
						if(i+1>data.length()-1)
							root.right=null;
						else
							root.right = buildTree(data.substring(i+1,data.length()-1));
						break;
					}
				}
			}	
			return root;
		}
	}
	static TreeNode buildTree(String data) {
		StringBuilder sb=new StringBuilder();
		int i=0,pos;
		char ch;
		int length=data.length();
		while(i<=length-1&&(ch=(char) data.charAt(i++))!='(') {
			sb.append(ch);
		}
		pos=i;
		TreeNode root=new TreeNode(Integer.parseInt(new String(sb)));
		if (i > length-1)
			return root;
		else {
			int count = 1;
			while (i <= length-1) {
				ch = (char) data.charAt(i++);
				if (ch == '(')
					count++;
				else if (ch == ')') {
					count--;
					if (count == 0) {
						if(i-pos==1)
							root.left=null;
						else
							root.left = buildTree(data.substring(pos, i-1));
						if(i+1>length-1)
							root.right=null;
						else
							root.right = buildTree(data.substring(i+1,length-1));
						break;
					}
				}
			}
		}
		return root;
	}

	static void add(TreeNode root) {
		if (root == null) {
			return;
		} else {
			if (root.left == null && root.right == null) {
				ans.append(root.val);
			} else if (root.left != null && root.right == null) {
				ans.append(root.val + "(");
				add(root.left);
				ans.append(")");
			} else {
				ans.append(root.val + "(");
				add(root.left);
				ans.append(")(");
				add(root.right);
				ans.append(")");
			}
		}
	}
	public static void main(String[] args) {
		TreeNode root=new TreeNode(2);
		/*root.left=new TreeNode(2);
		root.left.right=new TreeNode(8);*/
		root.left=new TreeNode(1);
		root.right=new TreeNode(3);
		
		String temp=serialize(root);
		TreeNode root2=deserialize(temp);
		System.out.println(root2.left.val);
	}
}
