package com.km.WeeklyContest117;

public class Univalued_Binary_Tree {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    public boolean isUnivalTree(TreeNode root) {
        if(root==null||(root.left==null&&root.right==null))
            return true;
        return isUnivalTree(root.left,root.val)&&isUnivalTree(root.right,root.val);
    }
    public boolean isUnivalTree(TreeNode root,int val) {
        if(root==null)
            return true;
        if(root.val!=val)
            return false;
        return isUnivalTree(root.left,val)&&isUnivalTree(root.right,val);
    }
}
