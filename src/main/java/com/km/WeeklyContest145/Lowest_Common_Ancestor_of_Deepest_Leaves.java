package com.km.WeeklyContest145;

public class Lowest_Common_Ancestor_of_Deepest_Leaves {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        if(root==null||(height(root.left)==height(root.right)))
            return root;
        return lcaDeepestLeaves(height(root.left)>height(root.right)?root.left:root.right);
    }
    public int height(TreeNode root){
        if(root==null)
            return 0;
        else
            return 1+Math.max(height(root.left),height(root.right));
    }
}
