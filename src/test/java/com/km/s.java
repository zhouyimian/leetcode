package com.km;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Stack;

public class s {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        return dfs(cloned,target);
    }

    private TreeNode dfs(TreeNode root, TreeNode target) {
        if(root==null||root.val==target.val)
            return root;
        TreeNode left = dfs(root.left,target);
        TreeNode right = dfs(root.right,target);
        return left==null?right:left;
    }
}
