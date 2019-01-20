package com.km.WeeklyContest120;

public class Distribute_Coins_in_Binary_Tree {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    int ans=0;
    public int distributeCoins(TreeNode root) {
        dfs(root);
        return ans;
    }
    public int dfs(TreeNode root){
        if(root==null)
            return 0;
        int left = dfs(root.left),right=dfs(root.right);
        ans+= Math.abs(left)+Math.abs(right);
        return root.val+left+right-1;
    }
}
