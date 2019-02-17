package com.km.WeeklyContest124;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Cousins_in_Binary_Tree {
    int deepx=-1,deepy=-2;
    public boolean isCousins(TreeNode root, int x, int y) {
        if(ifsameparent(root,x,y))
            return false;
        deep(root,x,y,1);
        return deepx==deepy;
    }

    private void deep(TreeNode root, int x, int y,int length) {
        if(root==null)
            return;
        if(root.val==x)
            deepx=length;
        if(root.val==y)
            deepy=length;
        deep(root.left,x,y,length+1);
        deep(root.right,x,y,length+1);
    }

    private boolean ifsameparent(TreeNode root, int x, int y) {
        if(root==null)
            return false;
        if(root.left!=null&&root.right!=null){
            if((root.left.val==x&&root.right.val==y)||(root.left.val==y&&root.right.val==x))
                return true;
        }
        return ifsameparent(root.left,x,y)||ifsameparent(root.right,x,y);
    }
}
