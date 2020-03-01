package com;

import java.util.*;

public class Main {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isCousins(TreeNode root, int x, int y) {
        int depthX = depth(root,x,0);
        int depthY = depth(root,y,0);
        if(depthX!=depthY)
            return false;
        TreeNode parentX = find(root,x);
        TreeNode parentY = find(root,y);
        return parentX!=parentY;
    }

    private TreeNode find(TreeNode root, int value) {
        if(root==null||root.val==value)
            return null;
        if((root.left!=null&&root.left.val==value)||(root.right!=null&&root.right.val==value))
            return root;
        TreeNode left = find(root.left,value);
        TreeNode right = find(root.right,value);
        return left==null?right:left;
    }
    private int depth(TreeNode root, int x,int len) {
        if(root==null)
            return -1;
        if(root.val==x)
            return len;
        return Math.max(depth(root.left,x,len+1),depth(root.right,x,len+1));
    }
}
