package com.km.WeeklyContest140;

public class Insufficient_Nodes_in_Root_to_Leaf_Paths {
    class TreeNode{
        TreeNode left;
        TreeNode right;
        int val;
    }
    public TreeNode sufficientSubset(TreeNode root, int limit) {
        if(root==null)
            return null;
        boolean ans = deal(root,limit,0);
        if(ans)
            return root;
        else
            return root.val>=limit?root:null;
    }
    public boolean deal(TreeNode root,int limit,int cur){
        boolean left = false;
        boolean right = false;
        cur+=root.val;
        if(root.left==null&&root.right==null){
            if(cur>=limit)
                return true;
            else
                return false;
        }
        if(root.left!=null){
            left = deal(root.left,limit,cur);
            if(!left)
                root.left = null;
        }
        if(root.right!=null){
            right = deal(root.right,limit,cur);
            if(!right)
                root.right = null;
        }
        if(!left&&!right)
            return false;
        return true;
    }
}
