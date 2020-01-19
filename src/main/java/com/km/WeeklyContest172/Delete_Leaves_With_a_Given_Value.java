package com.km.WeeklyContest172;

public class Delete_Leaves_With_a_Given_Value {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if(root==null)
            return root;
        boolean isdelete = deleteNode(root,target);
        return isdelete?null:root;
    }

    private boolean deleteNode(TreeNode root, int target) {
        if(root==null)
            return true;
        boolean deleteleft = deleteNode(root.left,target);
        boolean deleteright = deleteNode(root.right,target);
        if(deleteleft)
            root.left = null;
        if(deleteright)
            root.right = null;
        if(root.left==null&&root.right==null&&root.val==target)
            return true;
        return false;
    }
}