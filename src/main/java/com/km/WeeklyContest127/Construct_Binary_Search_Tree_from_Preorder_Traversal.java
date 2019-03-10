package com.km.WeeklyContest127;

import java.util.TreeMap;

public class Construct_Binary_Search_Tree_from_Preorder_Traversal {
    class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
    int i = 0;
    public TreeNode bstFromPreorder(int[] A) {
        return bstFromPreorder(A, 0, 100);
    }

    public TreeNode bstFromPreorder(int[] A, int lo, int hi) {
        if (i == A.length || A[i] < lo || A[i] > hi) return null;
        TreeNode root = new TreeNode(A[i++]);
        root.left = bstFromPreorder(A, lo, root.val);
        root.right = bstFromPreorder(A, root.val, hi);
        return root;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,1};
        Construct_Binary_Search_Tree_from_Preorder_Traversal test = new Construct_Binary_Search_Tree_from_Preorder_Traversal();
        test.bstFromPreorder(nums);
    }
}
