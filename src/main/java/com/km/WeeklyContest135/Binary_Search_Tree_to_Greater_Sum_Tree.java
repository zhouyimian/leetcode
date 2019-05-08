package com.km.WeeklyContest135;

public class Binary_Search_Tree_to_Greater_Sum_Tree {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    int pre = 0;

    public TreeNode bstToGst(TreeNode root) {
        if (root.right != null) bstToGst(root.right);
        pre = root.val = root.val + pre;
        if (root.left != null) bstToGst(root.left);
        return root;
    }
}
