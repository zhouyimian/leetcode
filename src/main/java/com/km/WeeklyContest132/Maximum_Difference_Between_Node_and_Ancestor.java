package com.km.WeeklyContest132;

import java.util.HashMap;
import java.util.Map;

public class Maximum_Difference_Between_Node_and_Ancestor {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    Map<TreeNode, Integer> MaxValue = new HashMap<>();
    Map<TreeNode, Integer> MinValue = new HashMap<>();
    int ans = Integer.MIN_VALUE;

    public int maxAncestorDiff(TreeNode root) {
        int leftmax = createMax(root.left);
        int rightmax = createMax(root.right);
        int leftmin = createMin(root.left);
        int rightmin = createMin(root.right);
        MaxValue.put(root,Math.max(leftmax,rightmax));
        MinValue.put(root,Math.min(leftmin,rightmin));
        dfs(root);
        return ans;
    }

    public void dfs(TreeNode root) {
        if (root == null || (root.left == null && root.right == null))
            return;
        int max = MaxValue.get(root);
        ans = Math.max(ans, Math.abs(root.val - max));
        int min = MinValue.get(root);
        ans = Math.max(ans, Math.abs(root.val - min));
        dfs(root.left);
        dfs(root.right);
    }

    public int createMax(TreeNode root) {
        int max = Integer.MIN_VALUE;
        if (root == null)
            return 0;
        if (root.left == null && root.right == null)
            return root.val;
        if (root.left != null) {
            max = Math.max(max, createMax(root.left));
        }
        if (root.right != null) {
            max = Math.max(max, createMax(root.right));
        }
        MaxValue.put(root, max);
        return root.val >= max ? root.val : max;
    }

    public int createMin(TreeNode root) {
        int min = Integer.MAX_VALUE;
        if (root == null)
            return 0;
        if (root.left == null && root.right == null)
            return root.val;
        if (root.left != null) {
            min = Math.min(min, createMin(root.left));
        }
        if (root.right != null) {
            min = Math.min(min, createMin(root.right));
        }
        MinValue.put(root, min);
        return root.val <= min ? root.val : min;
    }


    public static void main(String[] args) {
        Maximum_Difference_Between_Node_and_Ancestor test = new Maximum_Difference_Between_Node_and_Ancestor();
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(3);
        root.right = new TreeNode(5);
        System.out.println(test.maxAncestorDiff(root));
    }
}