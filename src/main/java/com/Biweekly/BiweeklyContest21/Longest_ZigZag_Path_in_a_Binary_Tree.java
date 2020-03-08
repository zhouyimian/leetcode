package com.Biweekly.BiweeklyContest21;

public class Longest_ZigZag_Path_in_a_Binary_Tree {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    int ans = 0;
    public int longestZigZag(TreeNode root) {
        if(root==null||(root.left==null&&root.right==null))
            return 0;
        ans = Math.max(longestZigZag(root.left,true)+1,ans);
        ans = Math.max(longestZigZag(root.right,false)+1,ans);
        return ans-1;
    }
    public int longestZigZag(TreeNode root,boolean isLeft){
        if(root==null)
            return 0;
        if(root.left==null&&root.right==null)
            return 1;
        int goRight = longestZigZag(root.right,false)+1;
        int goLeft = longestZigZag(root.left,true)+1;
        ans = Math.max(ans,goRight);
        ans = Math.max(ans,goLeft);
        return isLeft?goRight:goLeft;
    }

    public static void main(String[] args) {
        Longest_ZigZag_Path_in_a_Binary_Tree test = new Longest_ZigZag_Path_in_a_Binary_Tree();
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(1);
        root.right.left = new TreeNode(1);
        root.right.right = new TreeNode(1);
        root.right.right.right = new TreeNode(1);
        root.right.right.left = new TreeNode(1);
        root.right.right.left.right = new TreeNode(1);
        root.right.right.left.right.right = new TreeNode(1);
        System.out.println(test.longestZigZag(root));
    }
}
