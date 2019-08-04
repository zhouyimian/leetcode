package com.km.WeeklyContest148;

public class Binary_Tree_Coloring_Game {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    int[] count;
    TreeNode xleft = null;
    TreeNode xright = null;
    int target = -1;
    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        if(n==1)
            return false;
        target = x;
        count = new int[n+1];
        countChildren(root);
        if(root.val==x){
            int left = 0;
            int right = 0;
            if(root.left!=null)
                left = count[root.left.val];
            if(root.right!=null)
                right = count[root.right.val];
            if(left!=right)
                return true;
            return false;
        }
        if(count[x]<n-count[x])
            return true;
        if(xleft!=null){
            if(count[xleft.val]>n-count[xleft.val])
                return true;
            if(count[xright.val]>n-count[xright.val])
                return true;
        }
        return false;
    }

    private int countChildren(TreeNode root) {
        if(root==null)
            return 0;
        if(count[root.val]!=0)
            return count[root.val];
        if(root.val==target){
            xleft = root.left;
            xright = root.right;
        }
        int left = countChildren(root.left);
        int right = countChildren(root.right);
        count[root.val] = left+right+1;
        return count[root.val];
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        Binary_Tree_Coloring_Game test = new Binary_Tree_Coloring_Game();
        System.out.println(test.btreeGameWinningMove(root,3,2));
    }
}
